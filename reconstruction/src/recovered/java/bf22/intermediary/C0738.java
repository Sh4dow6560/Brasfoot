package bf22.intermediary;

import mod.recovered.competition.LeagueStage;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.model.Club;

public class C0738 {
   private static final int[][][] cX = new int[][][]{
      {{1, 2}, {19, 4}, {18, 5}, {17, 6}, {16, 7}, {15, 8}, {14, 9}, {13, 10}, {12, 11}},
      {{1, 3}, {2, 4}, {19, 6}, {18, 7}, {17, 8}, {16, 9}, {15, 10}, {14, 11}, {13, 12}},
      {{1, 4}, {3, 5}, {2, 6}, {19, 8}, {18, 9}, {17, 10}, {16, 11}, {15, 12}, {14, 13}},
      {{1, 5}, {4, 6}, {3, 7}, {2, 8}, {19, 10}, {18, 11}, {17, 12}, {16, 13}, {15, 14}},
      {{1, 6}, {5, 7}, {4, 8}, {3, 9}, {2, 10}, {19, 12}, {18, 13}, {17, 14}, {16, 15}},
      {{1, 7}, {6, 8}, {5, 9}, {4, 10}, {3, 11}, {2, 12}, {19, 14}, {18, 15}, {17, 16}},
      {{1, 8}, {7, 9}, {6, 10}, {5, 11}, {4, 12}, {3, 13}, {2, 14}, {19, 16}, {18, 17}},
      {{1, 9}, {8, 10}, {7, 11}, {6, 12}, {5, 13}, {4, 14}, {3, 15}, {2, 16}, {19, 18}},
      {{1, 10}, {9, 11}, {8, 12}, {7, 13}, {6, 14}, {5, 15}, {4, 16}, {3, 17}, {2, 18}},
      {{1, 11}, {10, 12}, {9, 13}, {8, 14}, {7, 15}, {6, 16}, {5, 17}, {4, 18}, {3, 19}},
      {{1, 12}, {11, 13}, {10, 14}, {9, 15}, {8, 16}, {7, 17}, {6, 18}, {5, 19}, {3, 2}},
      {{1, 13}, {12, 14}, {11, 15}, {10, 16}, {9, 17}, {8, 18}, {7, 19}, {5, 2}, {4, 3}},
      {{1, 14}, {13, 15}, {12, 16}, {11, 17}, {10, 18}, {9, 19}, {7, 2}, {6, 3}, {5, 4}},
      {{1, 15}, {14, 16}, {13, 17}, {12, 18}, {11, 19}, {9, 2}, {8, 3}, {7, 4}, {6, 5}},
      {{1, 16}, {15, 17}, {14, 18}, {13, 19}, {11, 2}, {10, 3}, {9, 4}, {8, 5}, {7, 6}},
      {{1, 17}, {16, 18}, {15, 19}, {13, 2}, {12, 3}, {11, 4}, {10, 5}, {9, 6}, {8, 7}},
      {{1, 18}, {17, 19}, {15, 2}, {14, 3}, {13, 4}, {12, 5}, {11, 6}, {10, 7}, {9, 8}},
      {{1, 19}, {17, 2}, {16, 3}, {15, 4}, {14, 5}, {13, 6}, {12, 7}, {11, 8}, {10, 9}},
      {{19, 2}, {18, 3}, {17, 4}, {16, 5}, {15, 6}, {14, 7}, {13, 8}, {12, 9}, {11, 10}}
   };
   private static final int[][][] cY = new int[][][]{
      {{4, 4, 2, 2}, {4, 1, 2, 4}, {4, 3, 2, 1}, {3, 2, 1, 1}, {3, 4, 1, 2}, {4, 2, 2, 3}, {3, 3, 1, 3}, {3, 1, 1, 4}},
      {{2, 3, 4, 4}, {2, 4, 4, 3}, {1, 2, 3, 3}, {1, 3, 3, 2}, {2, 1, 4, 2}, {2, 2, 4, 1}, {1, 1, 3, 1}, {1, 4, 3, 4}},
      {{4, 4, 2, 4}, {1, 2, 3, 1}, {3, 2, 1, 4}, {1, 1, 4, 3}, {4, 2, 2, 2}, {2, 1, 4, 1}, {2, 3, 3, 3}, {1, 3, 3, 4}},
      {{2, 4, 4, 2}, {4, 4, 2, 1}, {4, 1, 1, 2}, {2, 2, 3, 2}, {4, 3, 2, 3}, {3, 1, 1, 3}, {3, 4, 1, 1}, {3, 3, 1, 4}},
      {{2, 4, 3, 4}, {1, 2, 3, 2}, {1, 3, 4, 4}, {2, 2, 4, 3}, {2, 3, 3, 1}, {2, 1, 3, 3}, {1, 1, 4, 1}, {1, 4, 4, 2}},
      {{3, 1, 2, 4}, {3, 2, 2, 1}, {4, 4, 1, 1}, {4, 2, 1, 2}, {3, 3, 2, 2}, {3, 4, 2, 3}, {4, 1, 1, 3}, {4, 3, 1, 4}},
      {{2, 3, 3, 2}, {2, 4, 3, 3}, {1, 2, 4, 4}, {1, 3, 4, 3}, {2, 1, 3, 4}, {2, 2, 3, 1}, {1, 1, 4, 2}, {1, 4, 4, 1}},
      {{3, 2, 2, 4}, {4, 3, 1, 2}, {1, 4, 4, 4}, {3, 1, 2, 1}, {3, 4, 2, 2}, {3, 3, 1, 1}, {4, 2, 1, 3}, {4, 1, 2, 3}},
      {{4, 4, 3, 2}, {2, 4, 1, 3}, {2, 1, 1, 2}, {4, 3, 3, 1}, {2, 2, 1, 1}, {2, 3, 1, 4}, {4, 2, 3, 3}, {4, 1, 3, 4}},
      {{1, 1, 2, 4}, {1, 2, 2, 3}, {3, 2, 4, 2}, {3, 4, 4, 4}, {3, 3, 4, 3}, {1, 3, 2, 2}, {1, 4, 2, 1}, {3, 1, 4, 1}},
      {{2, 4, 1, 2}, {3, 3, 4, 4}, {3, 2, 4, 1}, {3, 4, 4, 3}, {2, 2, 1, 4}, {2, 3, 1, 1}, {2, 1, 1, 3}, {3, 1, 4, 2}},
      {{4, 3, 3, 2}, {1, 4, 2, 4}, {1, 2, 2, 2}, {4, 4, 3, 1}, {1, 3, 2, 3}, {1, 1, 2, 1}, {4, 1, 3, 3}, {4, 2, 3, 4}}
   };
   private static final int[][][] cZ = new int[][][]{
      {{4, 3, 1, 1}, {4, 1, 1, 5}, {4, 2, 1, 4}, {4, 5, 1, 3}, {4, 4, 1, 2}, {2, 3, 3, 1}, {2, 4, 3, 3}, {2, 2, 3, 4}, {2, 1, 3, 2}, {2, 5, 3, 5}},
      {{1, 1, 4, 5}, {1, 5, 4, 4}, {1, 3, 4, 3}, {1, 4, 4, 1}, {1, 2, 4, 2}, {3, 1, 2, 5}, {3, 4, 2, 3}, {3, 5, 2, 4}, {3, 2, 2, 2}, {3, 3, 2, 1}},
      {{1, 1, 4, 2}, {1, 2, 4, 5}, {4, 1, 1, 3}, {4, 3, 1, 5}, {1, 4, 4, 4}, {3, 1, 2, 1}, {3, 4, 2, 5}, {2, 3, 3, 5}, {2, 4, 3, 2}, {2, 2, 3, 3}},
      {{4, 1, 1, 1}, {4, 2, 1, 5}, {4, 5, 1, 4}, {4, 3, 1, 2}, {4, 4, 1, 3}, {3, 1, 2, 2}, {2, 1, 3, 5}, {2, 5, 3, 2}, {2, 3, 3, 3}, {3, 4, 2, 4}},
      {{4, 4, 1, 1}, {1, 4, 4, 3}, {1, 3, 4, 2}, {1, 5, 4, 5}, {1, 2, 4, 1}, {2, 4, 3, 1}, {3, 5, 2, 2}, {2, 1, 3, 4}, {3, 3, 2, 5}, {3, 2, 2, 3}},
      {{1, 1, 2, 3}, {2, 2, 1, 4}, {1, 3, 2, 4}, {1, 5, 2, 1}, {2, 5, 1, 2}, {4, 3, 3, 1}, {3, 4, 4, 4}, {3, 3, 4, 2}, {3, 5, 4, 1}, {4, 5, 3, 2}},
      {{2, 2, 1, 1}, {2, 3, 1, 2}, {2, 5, 1, 3}, {2, 4, 1, 5}, {2, 1, 1, 4}, {3, 1, 4, 5}, {4, 2, 3, 4}, {3, 2, 4, 3}, {4, 4, 3, 5}, {4, 1, 3, 3}},
      {{1, 1, 2, 1}, {1, 2, 2, 4}, {1, 3, 2, 3}, {1, 4, 2, 5}, {1, 5, 2, 2}, {3, 1, 4, 4}, {3, 2, 4, 2}, {3, 4, 4, 1}, {3, 5, 4, 3}, {3, 3, 4, 5}},
      {{1, 1, 2, 4}, {2, 5, 1, 5}, {2, 1, 1, 2}, {2, 2, 1, 3}, {2, 3, 1, 4}, {4, 1, 3, 1}, {4, 3, 3, 3}, {4, 4, 3, 2}, {4, 2, 3, 5}, {4, 5, 3, 4}},
      {{2, 5, 1, 1}, {2, 1, 1, 3}, {1, 2, 2, 2}, {1, 5, 2, 3}, {2, 4, 1, 4}, {3, 1, 4, 2}, {3, 2, 4, 1}, {3, 4, 4, 3}, {3, 5, 4, 5}, {3, 3, 4, 4}},
      {{1, 1, 3, 2}, {1, 3, 3, 4}, {1, 5, 3, 3}, {1, 2, 3, 1}, {1, 4, 3, 5}, {4, 1, 2, 3}, {4, 3, 2, 2}, {4, 2, 2, 4}, {4, 5, 2, 1}, {4, 4, 2, 5}},
      {{3, 1, 1, 1}, {3, 2, 1, 3}, {3, 5, 1, 2}, {3, 3, 1, 4}, {3, 4, 1, 5}, {2, 5, 4, 1}, {2, 3, 4, 5}, {2, 2, 4, 2}, {2, 4, 4, 4}, {2, 1, 4, 3}},
      {{1, 1, 3, 3}, {1, 5, 3, 5}, {1, 3, 3, 1}, {1, 2, 3, 4}, {1, 4, 3, 2}, {4, 1, 2, 4}, {4, 4, 2, 1}, {4, 2, 2, 5}, {4, 3, 2, 3}, {4, 5, 2, 2}},
      {{3, 4, 1, 1}, {3, 3, 1, 2}, {3, 2, 1, 5}, {3, 5, 1, 3}, {3, 1, 1, 4}, {2, 1, 4, 1}, {2, 5, 4, 3}, {2, 3, 4, 2}, {2, 2, 4, 4}, {2, 4, 4, 5}},
      {{1, 1, 3, 5}, {1, 5, 3, 1}, {1, 4, 3, 4}, {1, 2, 3, 2}, {1, 3, 3, 3}, {4, 1, 2, 2}, {4, 3, 2, 4}, {4, 2, 2, 1}, {4, 5, 2, 5}, {4, 4, 2, 3}}
   };
   private static final int[][][] da = new int[][][]{
      {{2, 4, 1, 3}, {2, 3, 1, 2}, {2, 1, 1, 1}, {2, 5, 1, 4}, {2, 6, 1, 6}, {2, 2, 1, 5}},
      {{1, 1, 2, 5}, {1, 6, 2, 2}, {1, 2, 2, 6}, {1, 4, 2, 1}, {1, 5, 2, 4}, {1, 3, 2, 3}},
      {{2, 4, 1, 6}, {2, 2, 1, 3}, {2, 1, 1, 2}, {2, 3, 1, 1}, {2, 6, 1, 4}, {2, 5, 1, 5}},
      {{1, 1, 2, 4}, {1, 6, 2, 3}, {1, 3, 2, 6}, {1, 2, 2, 5}, {1, 5, 2, 1}, {1, 4, 2, 2}},
      {{2, 3, 1, 4}, {2, 4, 1, 2}, {2, 2, 1, 1}, {2, 1, 1, 6}, {2, 6, 1, 5}, {2, 5, 1, 3}},
      {{1, 1, 2, 6}, {1, 2, 2, 2}, {1, 4, 2, 4}, {1, 6, 2, 5}, {1, 3, 2, 1}, {1, 5, 2, 3}}
   };
   private static final int[][][] db = new int[][][]{
      {{1, 8, 2, 6}, {1, 6, 2, 7}, {1, 3, 2, 1}, {1, 1, 2, 3}, {2, 4, 1, 2}, {2, 5, 1, 5}, {2, 8, 1, 4}, {2, 2, 1, 7}},
      {{1, 5, 2, 4}, {1, 4, 2, 2}, {1, 7, 2, 8}, {1, 2, 2, 5}, {2, 3, 1, 6}, {2, 7, 1, 1}, {2, 1, 1, 8}, {2, 6, 1, 3}},
      {{1, 8, 2, 8}, {1, 6, 2, 4}, {1, 3, 2, 2}, {1, 1, 2, 5}, {2, 3, 1, 5}, {2, 7, 1, 2}, {2, 1, 1, 7}, {2, 6, 1, 4}},
      {{1, 4, 2, 7}, {1, 5, 2, 1}, {1, 2, 2, 6}, {2, 5, 1, 3}, {1, 7, 2, 3}, {1, 8, 2, 4}, {2, 8, 1, 6}, {2, 2, 1, 1}},
      {{1, 4, 2, 4}, {1, 5, 2, 2}, {1, 7, 2, 5}, {1, 2, 2, 8}, {2, 3, 1, 3}, {2, 7, 1, 8}, {2, 1, 1, 1}, {2, 6, 1, 6}},
      {{1, 6, 2, 2}, {1, 3, 2, 4}, {1, 1, 2, 8}, {2, 3, 1, 4}, {2, 1, 1, 2}, {2, 6, 1, 5}, {1, 8, 2, 5}, {2, 7, 1, 7}},
      {{1, 8, 2, 3}, {1, 6, 2, 1}, {1, 3, 2, 7}, {1, 1, 2, 6}, {2, 4, 1, 7}, {2, 5, 1, 4}, {2, 8, 1, 5}, {2, 2, 1, 2}},
      {{1, 4, 2, 1}, {1, 5, 2, 7}, {1, 7, 2, 6}, {1, 2, 2, 3}, {2, 4, 1, 1}, {2, 5, 1, 6}, {2, 8, 1, 3}, {2, 2, 1, 8}}
   };
   private static final int[][] Jd = new int[][]{{2, 0}, {1, 2}, {1, 0}};
   private static final int[][] dc = new int[][]{{2, 0}, {1, 2}, {1, 0}, {0, 2}, {2, 1}, {0, 1}};
   private static final int[][][] dd = new int[][][]{
      {{1, 6}, {2, 7}, {3, 8}, {4, 9}},
      {{1, 2}, {3, 6}, {4, 7}, {5, 8}},
      {{1, 3}, {4, 2}, {5, 6}, {9, 8}},
      {{1, 4}, {5, 3}, {9, 6}, {8, 7}},
      {{1, 5}, {9, 3}, {7, 6}, {8, 2}},
      {{9, 5}, {8, 4}, {7, 3}, {6, 2}},
      {{1, 9}, {7, 5}, {2, 3}, {6, 4}},
      {{1, 8}, {7, 9}, {2, 5}, {3, 4}},
      {{1, 7}, {6, 8}, {2, 9}, {4, 5}}
   };
   private static final int[][][] Je = new int[][][]{{{0, 1}, {2, 3}}, {{0, 2}, {3, 1}}, {{3, 0}, {1, 2}}};
   private static final int[][][] de = new int[][][]{
      {{3, 2}, {1, 0}},
      {{1, 4}, {0, 2}},
      {{2, 1}, {4, 3}},
      {{0, 3}, {2, 4}},
      {{4, 0}, {3, 1}},
      {{2, 3}, {0, 1}},
      {{4, 1}, {2, 0}},
      {{1, 2}, {3, 4}},
      {{3, 0}, {4, 2}},
      {{0, 4}, {1, 3}}
   };
   private static final int[][][] Jf = new int[][][]{
      {{2, 1}, {0, 4}, {5, 3}},
      {{2, 0}, {5, 1}, {3, 4}},
      {{2, 5}, {3, 0}, {4, 1}},
      {{2, 4}, {1, 3}, {0, 5}},
      {{2, 3}, {4, 5}, {1, 0}},
      {{1, 2}, {4, 0}, {3, 5}},
      {{0, 2}, {1, 5}, {4, 3}},
      {{5, 2}, {0, 3}, {1, 4}},
      {{4, 2}, {3, 1}, {5, 0}},
      {{3, 2}, {5, 4}, {0, 1}}
   };
   private static final int[][][] df = new int[][][]{
      {{2, 0}, {1, 3}, {6, 5}, {7, 4}, {10, 8}, {11, 9}, {12, 14}, {13, 15}, {17, 18}, {16, 19}, {20, 22}, {23, 21}, {24, 26}, {27, 25}, {28, 29}, {30, 31}},
      {{2, 1}, {3, 0}, {7, 6}, {5, 4}, {9, 8}, {10, 11}, {12, 13}, {15, 14}, {16, 17}, {18, 19}, {21, 22}, {20, 23}, {24, 27}, {25, 26}, {29, 31}, {30, 28}},
      {{3, 2}, {0, 1}, {5, 7}, {4, 6}, {9, 10}, {8, 11}, {15, 12}, {14, 13}, {18, 16}, {19, 17}, {21, 20}, {22, 23}, {25, 24}, {26, 27}, {29, 30}, {31, 28}}
   };
   private static final int[][][] dg = new int[][][]{
      {{6, 4}, {7, 3}, {8, 2}, {9, 1}, {10, 0}},
      {{2, 0}, {3, 10}, {4, 9}, {5, 8}, {6, 7}},
      {{7, 5}, {8, 4}, {9, 3}, {10, 2}, {0, 1}},
      {{1, 10}, {2, 9}, {3, 8}, {4, 7}, {5, 6}},
      {{3, 1}, {4, 0}, {5, 10}, {6, 9}, {7, 8}},
      {{8, 6}, {9, 5}, {10, 4}, {0, 3}, {1, 2}},
      {{4, 2}, {5, 1}, {6, 0}, {7, 10}, {8, 9}},
      {{9, 7}, {10, 6}, {0, 5}, {1, 4}, {2, 3}},
      {{5, 3}, {6, 2}, {7, 1}, {8, 0}, {9, 10}},
      {{10, 8}, {0, 7}, {1, 6}, {2, 5}, {3, 4}},
      {{0, 9}, {1, 8}, {2, 7}, {3, 6}, {4, 5}}
   };
   private static final int[][][] dh = new int[][][]{
      {{1, 24}, {2, 23}, {3, 22}, {4, 21}, {5, 20}, {6, 19}, {7, 18}, {8, 17}, {9, 16}, {10, 15}, {11, 14}, {12, 13}},
      {{14, 12}, {15, 11}, {16, 10}, {17, 9}, {18, 8}, {19, 7}, {20, 6}, {21, 5}, {22, 4}, {23, 3}, {24, 2}, {0, 1}},
      {{2, 0}, {3, 24}, {4, 23}, {5, 22}, {6, 21}, {7, 20}, {8, 19}, {9, 18}, {10, 17}, {11, 16}, {12, 15}, {13, 14}},
      {{15, 13}, {16, 12}, {17, 11}, {18, 10}, {19, 9}, {20, 8}, {21, 7}, {22, 6}, {23, 5}, {24, 4}, {0, 3}, {1, 2}},
      {{3, 1}, {4, 0}, {5, 24}, {6, 23}, {7, 22}, {8, 21}, {9, 20}, {10, 19}, {11, 18}, {12, 17}, {13, 16}, {14, 15}},
      {{16, 14}, {17, 13}, {18, 12}, {19, 11}, {20, 10}, {21, 9}, {22, 8}, {23, 7}, {24, 6}, {0, 5}, {1, 4}, {2, 3}},
      {{4, 2}, {5, 1}, {6, 0}, {7, 24}, {8, 23}, {9, 22}, {10, 21}, {11, 20}, {12, 19}, {13, 18}, {14, 17}, {15, 16}},
      {{17, 15}, {18, 14}, {19, 13}, {20, 12}, {21, 11}, {22, 10}, {23, 9}, {24, 8}, {0, 7}, {1, 6}, {2, 5}, {3, 4}},
      {{5, 3}, {6, 2}, {7, 1}, {8, 0}, {9, 24}, {10, 23}, {11, 22}, {12, 21}, {13, 20}, {14, 19}, {15, 18}, {16, 17}},
      {{18, 16}, {19, 15}, {20, 14}, {21, 13}, {22, 12}, {23, 11}, {24, 10}, {0, 9}, {1, 8}, {2, 7}, {3, 6}, {4, 5}},
      {{6, 4}, {7, 3}, {8, 2}, {9, 1}, {10, 0}, {11, 24}, {12, 23}, {13, 22}, {14, 21}, {15, 20}, {16, 19}, {17, 18}},
      {{19, 17}, {20, 16}, {21, 15}, {22, 14}, {23, 13}, {24, 12}, {0, 11}, {1, 10}, {2, 9}, {3, 8}, {4, 7}, {5, 6}},
      {{7, 5}, {8, 4}, {9, 3}, {10, 2}, {11, 1}, {12, 0}, {13, 24}, {14, 23}, {15, 22}, {16, 21}, {17, 20}, {18, 19}},
      {{20, 18}, {21, 17}, {22, 16}, {23, 15}, {24, 14}, {0, 13}, {1, 12}, {2, 11}, {3, 10}, {4, 9}, {5, 8}, {6, 7}},
      {{8, 6}, {9, 5}, {10, 4}, {11, 3}, {12, 2}, {13, 1}, {14, 0}, {15, 24}, {16, 23}, {17, 22}, {18, 21}, {19, 20}},
      {{21, 19}, {22, 18}, {23, 17}, {24, 16}, {0, 15}, {1, 14}, {2, 13}, {3, 12}, {4, 11}, {5, 10}, {6, 9}, {7, 8}},
      {{9, 7}, {10, 6}, {11, 5}, {12, 4}, {13, 3}, {14, 2}, {15, 1}, {16, 0}, {17, 24}, {18, 23}, {19, 22}, {20, 21}},
      {{22, 20}, {23, 19}, {24, 18}, {0, 17}, {1, 16}, {2, 15}, {3, 14}, {4, 13}, {5, 12}, {6, 11}, {7, 10}, {8, 9}},
      {{10, 8}, {11, 7}, {12, 6}, {13, 5}, {14, 4}, {15, 3}, {16, 2}, {17, 1}, {18, 0}, {19, 24}, {20, 23}, {21, 22}},
      {{23, 21}, {24, 20}, {0, 19}, {1, 18}, {2, 17}, {3, 16}, {4, 15}, {5, 14}, {6, 13}, {7, 12}, {8, 11}, {9, 10}},
      {{11, 9}, {12, 8}, {13, 7}, {14, 6}, {15, 5}, {16, 4}, {17, 3}, {18, 2}, {19, 1}, {20, 0}, {21, 24}, {22, 23}},
      {{24, 22}, {0, 21}, {1, 20}, {2, 19}, {3, 18}, {4, 17}, {5, 16}, {6, 15}, {7, 14}, {8, 13}, {9, 12}, {10, 11}},
      {{12, 10}, {13, 9}, {14, 8}, {15, 7}, {16, 6}, {17, 5}, {18, 4}, {19, 3}, {20, 2}, {21, 1}, {22, 0}, {23, 24}},
      {{0, 23}, {1, 22}, {2, 21}, {3, 20}, {4, 19}, {5, 18}, {6, 17}, {7, 16}, {8, 15}, {9, 14}, {10, 13}, {11, 12}},
      {{13, 11}, {14, 10}, {15, 9}, {16, 8}, {17, 7}, {18, 6}, {19, 5}, {20, 4}, {21, 3}, {22, 2}, {23, 1}, {24, 0}}
   };

   public static Club[][][] a(LeagueStage c0955, ArrayList arrayList, int i) {
      Club[] var3 = new Club[arrayList.size()];
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < arrayList.size(); var5++) {
         var4.add(var5);
      }

      Collections.shuffle(var4);

      for (int var15 = 0; var15 < arrayList.size(); var15++) {
         var3[var15] = (Club)arrayList.get((Integer)var4.get(var15));
      }

      int var16 = var3.length;
      if (var16 % 2 == 1) {
         Club[] var6 = new Club[var16 + 1];

         for (int var7 = 0; var7 < var3.length; var7++) {
            var6[var7] = var3[var7];
         }

         var6[var16] = null;
         var3 = var6;
      }

      int var17 = var3.length - 1;
      int var18 = var3.length / 2;
      Club[][][] var8 = new Club[var17][var18][4];

      for (int var9 = 0; var9 < var17; var9++) {
         for (int var10 = 0; var10 < var18; var10++) {
            Club var11 = var3[(var9 + var10) % (var16 - 1)];
            Club var12 = var3[(var16 - 1 - var10 + var9) % (var16 - 1)];
            if (var10 == 0) {
               var12 = var3[var16 - 1];
            }

            var8[var9][var10][0] = var11;
            var8[var9][var10][3] = var12;
         }
      }

      Club[][][] var20 = new Club[var17][var18][4];
      int var21 = 0;
      int var22 = var3.length / 2;

      for (int var23 = 0; var23 < var8.length; var23++) {
         if (var23 % 2 == 0) {
            var20[var23] = var8[var21++];
         } else {
            var20[var23] = var8[var22++];
         }
      }

      var8 = var20;

      for (int var24 = 0; var24 < var8.length; var24++) {
         if (var24 % 2 == 1) {
            var8[var24][0] = a(var8[var24][0]);
         }
      }

      Club[][][] var25 = new Club[var17][var18][4];

      for (int var13 = 0; var13 < var17; var13++) {
         for (int var14 = 0; var14 < var18; var14++) {
            var25[var13][var14] = a((Club[])var8[var13][var14].clone());
         }
      }

      Club[][][] var26;
      if (i == 4) {
         var26 = new Club[var17 * 4][var18][4];

         for (int var27 = 0; var27 < var8.length; var27++) {
            var26[var27] = var8[var27];
         }

         for (int var28 = var8.length; var28 < var8.length + var25.length; var28++) {
            var26[var28] = var25[var28 - var8.length];
         }

         for (int var29 = var8.length + var25.length; var29 < var8.length + var25.length + var8.length; var29++) {
            var26[var29] = var8[var29 - var8.length - var25.length];
         }

         for (int var30 = var8.length + var25.length + var8.length; var30 < var8.length + var25.length + var8.length + var25.length; var30++) {
            var26[var30] = var25[var30 - var8.length - var25.length - var8.length];
         }
      } else if (i == 3) {
         var26 = new Club[var17 * 3][var18][4];

         for (int var31 = 0; var31 < var8.length; var31++) {
            var26[var31] = var8[var31];
         }

         for (int var32 = var8.length; var32 < var8.length + var25.length; var32++) {
            var26[var32] = var25[var32 - var8.length];
         }

         for (int var33 = var8.length + var25.length; var33 < var8.length + var25.length + var8.length; var33++) {
            var26[var33] = var8[var33 - var8.length - var25.length];
         }
      } else if (i == 2) {
         var26 = new Club[var17 * 2][var18][4];

         for (int var34 = 0; var34 < var8.length; var34++) {
            var26[var34] = var8[var34];
         }

         for (int var35 = var8.length; var35 < var8.length + var25.length; var35++) {
            var26[var35] = var25[var35 - var8.length];
         }
      } else {
         var26 = new Club[var17][var18][4];

         for (int var36 = 0; var36 < var8.length; var36++) {
            var26[var36] = var8[var36];
         }
      }

      return var26;
   }

   public static void e(int i, int j) {
      if ((i % 2 == 0 || j == i - 1) && i > 0) {
         int[] var2 = new int[i];
         int var3 = i / 2;

         for (int var4 = 0; var4 < var3; var4++) {
            var2[var4] = var4 + 1;
            var2[i - var4 - 1] = var2[var4] + var3;
         }

         for (int var8 = 1; var8 <= j; var8++) {
            int var5 = var2[1];

            for (int var6 = 1; var6 < i - 1; var6++) {
               int var7 = var2[var6 + 1];
               var2[var6 + 1] = var5;
               var5 = var7;
            }

            var2[1] = var5;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   public static Club[][][] a(ArrayList arrayList, ArrayList arrayList2) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var13 = 16;
      byte var4 = 12;
      byte var5 = 8;
      Club[][][] var6 = new Club[var4][var5][4];

      for (int var7 = 0; var7 < var4; var7++) {
         for (int var8 = 0; var8 < var5; var8++) {
            int var9 = cY[var7][var8][0] - 1;
            int var10 = cY[var7][var8][1] - 1;
            var6[var7][var8][0] = (Club)((C0673)arrayList2.get(var9)).gR().get(var10);
            int var11 = cY[var7][var8][2] - 1;
            int var12 = cY[var7][var8][3] - 1;
            var6[var7][var8][3] = (Club)((C0673)arrayList2.get(var11)).gR().get(var12);
         }
      }

      Club[][][] var14 = new Club[var4][var5][4];

      for (int var15 = 0; var15 < var6.length; var15++) {
         var14[var15] = var6[var15];
      }

      return var14;
   }

   public static Club[][][] b(ArrayList arrayList, ArrayList arrayList2) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var13 = 20;
      byte var4 = 15;
      byte var5 = 10;
      Club[][][] var6 = new Club[var4][var5][4];

      for (int var7 = 0; var7 < var4; var7++) {
         for (int var8 = 0; var8 < var5; var8++) {
            int var9 = cZ[var7][var8][0] - 1;
            int var10 = cZ[var7][var8][1] - 1;
            var6[var7][var8][0] = (Club)((C0673)arrayList2.get(var9)).gR().get(var10);
            int var11 = cZ[var7][var8][2] - 1;
            int var12 = cZ[var7][var8][3] - 1;
            var6[var7][var8][3] = (Club)((C0673)arrayList2.get(var11)).gR().get(var12);
         }
      }

      Club[][][] var14 = new Club[var4][var5][4];

      for (int var15 = 0; var15 < var6.length; var15++) {
         var14[var15] = var6[var15];
      }

      return var14;
   }

   private static Club[] a(Club[] clubs) {
      Club var1 = clubs[3];
      clubs[3] = clubs[0];
      clubs[0] = var1;
      return clubs;
   }

   public static Club[][][] a(LeagueStage c0955, ArrayList arrayList) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var9 = 6;
      byte var4 = 1;
      Club[][][] var5 = new Club[var9][var4][4];

      for (int var6 = 0; var6 < var9; var6++) {
         int var7 = dc[var6][0];
         var5[var6][0][0] = (Club)arrayList.get(var7);
         int var8 = dc[var6][1];
         var5[var6][0][3] = (Club)arrayList.get(var8);
      }

      Club[][][] var10 = new Club[var9][var4][4];

      for (int var11 = 0; var11 < var5.length; var11++) {
         var10[var11] = var5[var11];
      }

      return var10;
   }

   public static Club[][][] g(LeagueStage c0955, ArrayList arrayList) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var9 = 3;
      byte var4 = 1;
      Club[][][] var5 = new Club[var9][var4][4];

      for (int var6 = 0; var6 < var9; var6++) {
         int var7 = Jd[var6][0];
         var5[var6][0][0] = (Club)arrayList.get(var7);
         int var8 = Jd[var6][1];
         var5[var6][0][3] = (Club)arrayList.get(var8);
      }

      Club[][][] var10 = new Club[var9][var4][4];

      for (int var11 = 0; var11 < var5.length; var11++) {
         var10[var11] = var5[var11];
      }

      return var10;
   }

   public static Club[][][] a(LeagueStage c0955, ArrayList arrayList, boolean bl) {
      Club[] var3 = new Club[arrayList.size()];

      for (int var4 = 0; var4 < arrayList.size(); var4++) {
         var3[var4] = (Club)arrayList.get(var4);
      }

      byte var12 = 9;
      byte var5 = 4;
      byte var6 = 9;
      if (bl) {
         var6 = 18;
      }

      Club[][][] var7 = new Club[var6][var5][4];

      for (int var8 = 0; var8 < var12; var8++) {
         for (int var9 = 0; var9 < var5; var9++) {
            int var10 = dd[var8][var9][0] - 1;
            var7[var8][var9][0] = (Club)arrayList.get(var10);
            int var11 = dd[var8][var9][1] - 1;
            var7[var8][var9][3] = (Club)arrayList.get(var11);
         }
      }

      if (bl) {
         for (int var13 = 0; var13 < var12; var13++) {
            for (int var15 = 0; var15 < var5; var15++) {
               int var17 = dd[var13][var15][1] - 1;
               var7[var13 + var12][var15][0] = (Club)arrayList.get(var17);
               int var18 = dd[var13][var15][0] - 1;
               var7[var13 + var12][var15][3] = (Club)arrayList.get(var18);
            }
         }
      }

      Club[][][] var14 = new Club[var6][var5][4];

      for (int var16 = 0; var16 < var7.length; var16++) {
         var14[var16] = var7[var16];
      }

      return var14;
   }

   public static Club[][][] y(ArrayList arrayList) {
      Club[] var1 = new Club[arrayList.size()];

      for (int var2 = 0; var2 < arrayList.size(); var2++) {
         var1[var2] = (Club)arrayList.get(var2);
      }

      byte var9 = 5;
      byte var3 = 2;
      Club[][][] var4 = new Club[var9][var3][4];

      for (int var5 = 0; var5 < var9; var5++) {
         for (int var6 = 0; var6 < var3; var6++) {
            int var7 = de[var5][var6][0];
            var4[var5][var6][0] = (Club)arrayList.get(var7);
            int var8 = de[var5][var6][1];
            var4[var5][var6][3] = (Club)arrayList.get(var8);
         }
      }

      Club[][][] var10 = new Club[var9][var3][4];

      for (int var11 = 0; var11 < var4.length; var11++) {
         var10[var11] = var4[var11];
      }

      return var10;
   }

   public static Club[][][] v(ArrayList arrayList) {
      Club[] var1 = new Club[arrayList.size()];

      for (int var2 = 0; var2 < arrayList.size(); var2++) {
         var1[var2] = (Club)arrayList.get(var2);
      }

      byte var9 = 3;
      byte var3 = 2;
      Club[][][] var4 = new Club[var9][var3][4];

      for (int var5 = 0; var5 < var9; var5++) {
         for (int var6 = 0; var6 < var3; var6++) {
            int var7 = Je[var5][var6][0];
            var4[var5][var6][0] = (Club)arrayList.get(var7);
            int var8 = Je[var5][var6][1];
            var4[var5][var6][3] = (Club)arrayList.get(var8);
         }
      }

      Club[][][] var10 = new Club[var9][var3][4];

      for (int var11 = 0; var11 < var4.length; var11++) {
         var10[var11] = var4[var11];
      }

      return var10;
   }

   public static Club[][][] b(LeagueStage c0955, ArrayList arrayList) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var10 = 10;
      byte var4 = 2;
      Club[][][] var5 = new Club[var10][var4][4];

      for (int var6 = 0; var6 < var10; var6++) {
         for (int var7 = 0; var7 < var4; var7++) {
            int var8 = de[var6][var7][0];
            var5[var6][var7][0] = (Club)arrayList.get(var8);
            int var9 = de[var6][var7][1];
            var5[var6][var7][3] = (Club)arrayList.get(var9);
         }
      }

      Club[][][] var11 = new Club[var10][var4][4];

      for (int var12 = 0; var12 < var5.length; var12++) {
         var11[var12] = var5[var12];
      }

      return var11;
   }

   public static Club[][][] h(LeagueStage c0955, ArrayList arrayList) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var10 = 10;
      byte var4 = 3;
      Club[][][] var5 = new Club[var10][var4][4];

      for (int var6 = 0; var6 < var10; var6++) {
         for (int var7 = 0; var7 < var4; var7++) {
            int var8 = Jf[var6][var7][0];
            var5[var6][var7][0] = (Club)arrayList.get(var8);
            int var9 = Jf[var6][var7][1];
            var5[var6][var7][3] = (Club)arrayList.get(var9);
         }
      }

      Club[][][] var11 = new Club[var10][var4][4];

      for (int var12 = 0; var12 < var5.length; var12++) {
         var11[var12] = var5[var12];
      }

      return var11;
   }

   public static Club[][][] c(LeagueStage c0955, ArrayList arrayList) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var10 = 11;
      byte var4 = 5;
      Club[][][] var5 = new Club[var10][var4][4];

      for (int var6 = 0; var6 < var10; var6++) {
         for (int var7 = 0; var7 < var4; var7++) {
            int var8 = dg[var6][var7][0];
            var5[var6][var7][0] = (Club)arrayList.get(var8);
            int var9 = dg[var6][var7][1];
            var5[var6][var7][3] = (Club)arrayList.get(var9);
         }
      }

      Club[][][] var11 = new Club[var10][var4][4];

      for (int var12 = 0; var12 < var5.length; var12++) {
         var11[var12] = var5[var12];
      }

      return var11;
   }

   public static Club[][][] d(LeagueStage c0955, ArrayList arrayList) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var10 = 25;
      byte var4 = 12;
      Club[][][] var5 = new Club[var10][var4][4];

      for (int var6 = 0; var6 < var10; var6++) {
         for (int var7 = 0; var7 < var4; var7++) {
            int var8 = dh[var6][var7][0];
            var5[var6][var7][0] = (Club)arrayList.get(var8);
            int var9 = dh[var6][var7][1];
            var5[var6][var7][3] = (Club)arrayList.get(var9);
         }
      }

      Club[][][] var11 = new Club[var10][var4][4];

      for (int var12 = 0; var12 < var5.length; var12++) {
         var11[var12] = var5[var12];
      }

      return var11;
   }

   public static Club[][][] e(LeagueStage c0955, ArrayList arrayList) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var10 = 19;
      byte var4 = 9;
      Club[][][] var5 = new Club[var10][var4][4];

      for (int var6 = 0; var6 < var10; var6++) {
         for (int var7 = 0; var7 < var4; var7++) {
            int var8 = cX[var6][var7][0];
            var5[var6][var7][0] = (Club)arrayList.get(var8 - 1);
            int var9 = cX[var6][var7][1];
            var5[var6][var7][3] = (Club)arrayList.get(var9 - 1);
         }
      }

      Club[][][] var11 = new Club[var10][var4][4];

      for (int var12 = 0; var12 < var10; var12++) {
         for (int var14 = 0; var14 < var4; var14++) {
            var11[var12][var14] = a((Club[])var5[var12][var14].clone());
         }
      }

      Club[][][] var13 = new Club[var10 * 2][var4][4];

      for (int var15 = 0; var15 < var5.length; var15++) {
         var13[var15] = var5[var15];
      }

      for (int var16 = var5.length; var16 < var5.length + var11.length; var16++) {
         var13[var16] = var11[var16 - var5.length];
      }

      return var13;
   }

   public static Club[][][] c(ArrayList arrayList, ArrayList arrayList2) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var13 = 12;
      byte var4 = 6;
      byte var5 = 6;
      Club[][][] var6 = new Club[var4][var5][4];

      for (int var7 = 0; var7 < var4; var7++) {
         for (int var8 = 0; var8 < var5; var8++) {
            int var9 = da[var7][var8][0] - 1;
            int var10 = da[var7][var8][1] - 1;
            var6[var7][var8][0] = (Club)((C0673)arrayList2.get(var9)).gR().get(var10);
            int var11 = da[var7][var8][2] - 1;
            int var12 = da[var7][var8][3] - 1;
            var6[var7][var8][3] = (Club)((C0673)arrayList2.get(var11)).gR().get(var12);
         }
      }

      Club[][][] var14 = new Club[var4][var5][4];

      for (int var15 = 0; var15 < var6.length; var15++) {
         var14[var15] = var6[var15];
      }

      return var14;
   }

   public static Club[][][] f(LeagueStage c0955, ArrayList arrayList) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var11 = 32;
      byte var4 = 3;
      byte var5 = 16;
      Club[][][] var6 = new Club[var4][var5][4];

      for (int var7 = 0; var7 < var4; var7++) {
         for (int var8 = 0; var8 < var5; var8++) {
            int var9 = df[var7][var8][0];
            var6[var7][var8][0] = (Club)arrayList.get(var9);
            int var10 = df[var7][var8][1];
            var6[var7][var8][3] = (Club)arrayList.get(var10);
         }
      }

      Club[][][] var12 = new Club[var4][var5][4];

      for (int var13 = 0; var13 < var6.length; var13++) {
         var12[var13] = var6[var13];
      }

      return var12;
   }

   public static Club[][][] d(ArrayList arrayList, ArrayList arrayList2) {
      Club[] var2 = new Club[arrayList.size()];

      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         var2[var3] = (Club)arrayList.get(var3);
      }

      byte var13 = 16;
      byte var4 = 8;
      byte var5 = 8;
      Club[][][] var6 = new Club[var4][var5][4];

      for (int var7 = 0; var7 < var4; var7++) {
         for (int var8 = 0; var8 < var5; var8++) {
            int var9 = db[var7][var8][0] - 1;
            int var10 = db[var7][var8][1] - 1;
            var6[var7][var8][0] = (Club)((C0673)arrayList2.get(var9)).gR().get(var10);
            int var11 = db[var7][var8][2] - 1;
            int var12 = db[var7][var8][3] - 1;
            var6[var7][var8][3] = (Club)((C0673)arrayList2.get(var11)).gR().get(var12);
         }
      }

      Club[][][] var14 = new Club[var4][var5][4];

      for (int var15 = 0; var15 < var6.length; var15++) {
         var14[var15] = var6[var15];
      }

      return var14;
   }

   private static boolean a(Club club, Club club2, ArrayList arrayList) {
      boolean var3 = false;
      if (arrayList != null && arrayList.size() != 0) {
         for (int var4 = 0; var4 < arrayList.size(); var4++) {
            if (((C0673)arrayList.get(var4)).gR().contains(club) && ((C0673)arrayList.get(var4)).gR().contains(club2)) {
               var3 = true;
               break;
            }
         }

         return var3;
      } else {
         return false;
      }
   }
}
