package mod.extension.reach;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import mod.extension.state.Feature;
import mod.extension.state.ModRuntime;
import mod.recovered.game.CareerState;
import mod.recovered.manager.CoachSeasonRecord;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.model.Stadium;
import mod.recovered.save.GamePersistence;

public final class ClubReachBridge {
  private ClubReachBridge() {
  }

  public static int processMonthly(int year, int month) {
    if (!ModRuntime.isFeatureEnabled(Feature.CLUB_REACH)) {
      return 0;
    }
    CareerState career = GamePersistence.careerState;
    if (career == null || career.M() == null) {
      return 0;
    }
    int updated = 0;
    ArrayList coaches = career.M();
    for (int index = 0; index < coaches.size(); index++) {
      Object value = coaches.get(index);
      if (!(value instanceof Coach)) {
        continue;
      }
      Coach coach = (Coach)value;
      Club club = coach.getClub();
      if (!Boolean.TRUE.equals(coach.isUserControlled()) || club == null) {
        continue;
      }
      try {
        ClubReachResult result = ModRuntime.evaluateClubReach(
            snapshot(club, coach, year, month));
        if (result.isStateChanged()) {
          updated++;
        }
      } catch (RuntimeException exception) {
        System.err.println("Club reach update failed: " + exception.getMessage());
      }
    }
    return updated;
  }

  public static int openDashboard(Component parent) {
    if (!ModRuntime.isFeatureEnabled(Feature.CLUB_REACH)) {
      show(parent, "Ative o recurso em Recursos adicionais.");
      return 0;
    }
    CareerState career = GamePersistence.careerState;
    if (career == null || career.M() == null) {
      show(parent, "Nenhuma carreira ativa.");
      return 0;
    }

    Calendar date = career.getCurrentDate();
    StringBuilder report = new StringBuilder();
    int profiles = 0;
    ArrayList coaches = career.M();
    for (int index = 0; index < coaches.size(); index++) {
      Object value = coaches.get(index);
      if (!(value instanceof Coach)) {
        continue;
      }
      Coach coach = (Coach)value;
      Club club = coach.getClub();
      if (!Boolean.TRUE.equals(coach.isUserControlled()) || club == null) {
        continue;
      }
      try {
        ClubReachResult result = ModRuntime.evaluateClubReach(
            snapshot(
                club,
                coach,
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH) + 1));
        if (report.length() > 0) {
          report.append("\n\n");
        }
        report.append(ClubReachFormatter.dashboard(club.getNome(), result));
        profiles++;
      } catch (RuntimeException exception) {
        System.err.println("Club reach dashboard failed: " + exception.getMessage());
      }
    }
    if (profiles == 0) {
      show(parent, "Nenhum clube controlado pelo usuario.");
      return 0;
    }
    show(parent, report.toString());
    return profiles;
  }

  private static ClubReachSnapshot snapshot(
      Club club, Coach coach, int year, int month) {
    CoachSeasonRecord season = coach.getOrCreateSeasonRecord(club);
    Stadium stadium = club.getStadium();
    return new ClubReachSnapshot(
        year,
        month,
        GamePersistence.careerState.getSeasonNumber(),
        club.getClubId(),
        club.getDivisao(),
        club.getReputation(),
        coach.getFanApproval(),
        stadium == null ? 0 : stadium.getCapacity(),
        season.getMatchCount(),
        season.getWinCount(),
        season.getLossCount(),
        season.getTitleCount());
  }

  private static void show(Component parent, String text) {
    if (GraphicsEnvironment.isHeadless()) {
      return;
    }
    JTextArea content = new JTextArea(text, 15, 48);
    content.setEditable(false);
    content.setLineWrap(true);
    content.setWrapStyleWord(true);
    content.setCaretPosition(0);
    JScrollPane scroll = new JScrollPane(content);
    scroll.setPreferredSize(new Dimension(560, 320));
    JOptionPane.showMessageDialog(
        parent,
        scroll,
        "Torcida e alcance mundial",
        JOptionPane.PLAIN_MESSAGE);
  }
}
