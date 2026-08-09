package mod.extension.infrastructure;

public enum FacilityType {
  PITCH("pitch", "Gramado", 500_000, 8_000, 1),
  TRAINING("training", "Centro de treinamento", 1_200_000, 18_000, 2),
  MEDICAL("medical", "Departamento m\u00e9dico", 900_000, 14_000, 2),
  YOUTH("youth", "Categorias de base", 1_000_000, 12_000, 2),
  COMMERCIAL("commercial", "Estrutura comercial", 1_100_000, 14_000, 2);

  private final String id;
  private final String label;
  private final int baseUpgradeCost;
  private final int maintenancePerLevel;
  private final int durationFactor;

  FacilityType(
      String id,
      String label,
      int baseUpgradeCost,
      int maintenancePerLevel,
      int durationFactor) {
    this.id = id;
    this.label = label;
    this.baseUpgradeCost = baseUpgradeCost;
    this.maintenancePerLevel = maintenancePerLevel;
    this.durationFactor = durationFactor;
  }

  public String getId() {
    return this.id;
  }

  public String getLabel() {
    return this.label;
  }

  int getBaseUpgradeCost() {
    return this.baseUpgradeCost;
  }

  int getMaintenancePerLevel() {
    return this.maintenancePerLevel;
  }

  int durationMonths(int targetLevel) {
    return Math.max(2, targetLevel * this.durationFactor);
  }

  static FacilityType fromId(String id) {
    for (FacilityType type : values()) {
      if (type.id.equals(id)) {
        return type;
      }
    }
    throw new IllegalArgumentException("Unknown facility type: " + id);
  }

  @Override
  public String toString() {
    return this.label;
  }
}
