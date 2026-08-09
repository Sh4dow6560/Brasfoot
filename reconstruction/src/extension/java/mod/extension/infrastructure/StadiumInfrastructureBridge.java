package mod.extension.infrastructure;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import mod.extension.state.Feature;
import mod.extension.state.ModRuntime;
import mod.recovered.game.CareerState;
import mod.recovered.manager.CoachSeasonRecord;
import mod.recovered.match.Match;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Stadium;
import mod.recovered.save.GamePersistence;

public final class StadiumInfrastructureBridge {
  private static final int STADIUM_EXPENSE_CATEGORY = 7;

  private StadiumInfrastructureBridge() {
  }

  public static int processMonthly(int year, int month) {
    if (!ModRuntime.isFeatureEnabled(Feature.STADIUM_INFRASTRUCTURE)) {
      return 0;
    }
    CareerState career = GamePersistence.careerState;
    if (career == null || career.M() == null) {
      return 0;
    }

    int processed = 0;
    ArrayList coaches = career.M();
    for (int index = 0; index < coaches.size(); index++) {
      Object value = coaches.get(index);
      if (!(value instanceof Coach)) {
        continue;
      }
      Coach coach = (Coach)value;
      Club club = coach.getClub();
      Stadium stadium = club == null ? null : club.getStadium();
      if (!Boolean.TRUE.equals(coach.isUserControlled()) || stadium == null) {
        continue;
      }
      try {
        InfrastructureResult result = ModRuntime.processInfrastructureMonth(
            snapshot(club, coach, stadium, year, month));
        if (result.getExpenseDue() > 0) {
          club.debit(result.getExpenseDue(), STADIUM_EXPENSE_CATEGORY);
        }
        if (result.getProfile() != null) {
          int pitchCondition = result.getProfile().getLegacyPitchCondition();
          stadium.setPitchCondition(pitchCondition);
          synchronizeScheduledMatches(
              career, club, stadium, pitchCondition);
        }
        if (result.isStateChanged()) {
          processed++;
        }
      } catch (RuntimeException exception) {
        System.err.println(
            "Infrastructure monthly update failed: " + exception.getMessage());
      }
    }
    return processed;
  }

  public static int openDashboard(Component parent) {
    if (!ModRuntime.isFeatureEnabled(Feature.STADIUM_INFRASTRUCTURE)) {
      show(parent, "Ative o recurso em Recursos adicionais.", "Infraestrutura");
      return 0;
    }
    CareerState career = GamePersistence.careerState;
    if (career == null || career.M() == null) {
      show(parent, "Nenhuma carreira ativa.", "Infraestrutura");
      return 0;
    }
    List<ClubContext> clubs = userClubs(career);
    if (clubs.isEmpty()) {
      show(parent, "Nenhum clube controlado pelo usu\u00e1rio.", "Infraestrutura");
      return 0;
    }
    if (GraphicsEnvironment.isHeadless()) {
      return 0;
    }

    ClubContext selected = chooseClub(parent, clubs);
    if (selected == null) {
      return 0;
    }
    Calendar date = career.getCurrentDate();
    InfrastructureSnapshot snapshot = snapshot(
        selected.club,
        selected.coach,
        selected.stadium,
        date.get(Calendar.YEAR),
        date.get(Calendar.MONTH) + 1);
    InfrastructureResult result = ModRuntime.inspectInfrastructure(snapshot);
    String dashboard = InfrastructureFormatter.dashboard(
        selected.club.getNome(),
        selected.stadium.getName(),
        selected.stadium.getCapacity(),
        selected.club.getCashBalance(),
        result);
    Object[] options = result.getActiveProject() == null
        ? new Object[]{"Melhorar infraestrutura", "Fechar"}
        : new Object[]{"Fechar"};
    int choice = JOptionPane.showOptionDialog(
        parent,
        scroll(dashboard),
        "Est\u00e1dio e infraestrutura",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null,
        options,
        options[options.length - 1]);
    if (result.getActiveProject() != null || choice != 0) {
      return 1;
    }

    FacilityType[] available = availableFacilities(result.getProfile());
    if (available.length == 0) {
      show(
          parent,
          "Todas as estruturas j\u00e1 est\u00e3o no n\u00edvel m\u00e1ximo.",
          "Infraestrutura");
      return 1;
    }
    FacilityType facility = (FacilityType)JOptionPane.showInputDialog(
        parent,
        "Escolha a estrutura que ser\u00e1 melhorada:",
        "Nova obra",
        JOptionPane.PLAIN_MESSAGE,
        null,
        available,
        available[0]);
    if (facility == null) {
      return 1;
    }

    InfrastructureUpgradeOffer offer =
        ModRuntime.quoteInfrastructureUpgrade(snapshot, facility);
    if (selected.club.getCashBalance() < offer.getCost()) {
      show(
          parent,
          InfrastructureFormatter.upgradeOffer(offer)
              + "\n\nO clube n\u00e3o possui dinheiro suficiente.",
          "Nova obra");
      return 1;
    }
    int confirmation = JOptionPane.showConfirmDialog(
        parent,
        InfrastructureFormatter.upgradeOffer(offer)
            + "\n\nIniciar esta obra?",
        "Nova obra",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    if (confirmation != JOptionPane.YES_OPTION) {
      return 1;
    }

    InfrastructureResult started =
        ModRuntime.startInfrastructureUpgrade(snapshot, facility);
    selected.club.debit(started.getExpenseDue(), STADIUM_EXPENSE_CATEGORY);
    show(
        parent,
        "Obra iniciada. Conclus\u00e3o prevista para "
            + InfrastructureFormatter.period(
                started.getActiveProject().getCompletionPeriod())
            + ".",
        "Infraestrutura");
    return 1;
  }

  private static InfrastructureSnapshot snapshot(
      Club club,
      Coach coach,
      Stadium stadium,
      int year,
      int month) {
    CoachSeasonRecord season = coach.getOrCreateSeasonRecord(club);
    return new InfrastructureSnapshot(
        year,
        month,
        GamePersistence.careerState.getSeasonNumber(),
        club.getClubId(),
        club.getDivisao(),
        club.getReputation(),
        stadium.getCapacity(),
        stadium.getPitchCondition(),
        season.getMatchCount(),
        club.getCashBalance());
  }

  private static void synchronizeScheduledMatches(
      CareerState career,
      Club club,
      Stadium stadium,
      int pitchCondition) {
    for (int scheduleIndex = career.getCurrentScheduleIndex();
        scheduleIndex < career.getScheduleDays().size();
        scheduleIndex++) {
      ArrayList matches = career.getMatchesAtScheduleIndex(scheduleIndex);
      if (matches == null) {
        continue;
      }
      for (int matchIndex = 0; matchIndex < matches.size(); matchIndex++) {
        Object value = matches.get(matchIndex);
        if (!(value instanceof Match)) {
          continue;
        }
        Match match = (Match)value;
        if (match.getHomeClub() == club && match.getStadium() == stadium) {
          match.setPitchCondition(pitchCondition);
        }
      }
    }
  }

  private static List<ClubContext> userClubs(CareerState career) {
    List<ClubContext> result = new ArrayList<ClubContext>();
    ArrayList coaches = career.M();
    for (int index = 0; index < coaches.size(); index++) {
      Object value = coaches.get(index);
      if (!(value instanceof Coach)) {
        continue;
      }
      Coach coach = (Coach)value;
      Club club = coach.getClub();
      Stadium stadium = club == null ? null : club.getStadium();
      if (Boolean.TRUE.equals(coach.isUserControlled()) && stadium != null) {
        result.add(new ClubContext(coach, club, stadium));
      }
    }
    return result;
  }

  private static ClubContext chooseClub(
      Component parent, List<ClubContext> clubs) {
    if (clubs.size() == 1) {
      return clubs.get(0);
    }
    Object[] choices = clubs.toArray();
    return (ClubContext)JOptionPane.showInputDialog(
        parent,
        "Escolha o clube:",
        "Est\u00e1dio e infraestrutura",
        JOptionPane.PLAIN_MESSAGE,
        null,
        choices,
        choices[0]);
  }

  private static FacilityType[] availableFacilities(
      InfrastructureProfile profile) {
    List<FacilityType> result = new ArrayList<FacilityType>();
    for (FacilityType type : FacilityType.values()) {
      if (profile.getLevel(type) < 5) {
        result.add(type);
      }
    }
    return result.toArray(new FacilityType[result.size()]);
  }

  private static JScrollPane scroll(String text) {
    JTextArea content = new JTextArea(text, 16, 48);
    content.setEditable(false);
    content.setLineWrap(true);
    content.setWrapStyleWord(true);
    content.setCaretPosition(0);
    JScrollPane scroll = new JScrollPane(content);
    scroll.setPreferredSize(new Dimension(560, 340));
    return scroll;
  }

  private static void show(Component parent, String text, String title) {
    if (!GraphicsEnvironment.isHeadless()) {
      JOptionPane.showMessageDialog(
          parent, scroll(text), title, JOptionPane.PLAIN_MESSAGE);
    }
  }

  private static final class ClubContext {
    private final Coach coach;
    private final Club club;
    private final Stadium stadium;

    private ClubContext(Coach coach, Club club, Stadium stadium) {
      this.coach = coach;
      this.club = club;
      this.stadium = stadium;
    }

    @Override
    public String toString() {
      return this.club.getNome();
    }
  }
}
