package it.estrazioni.superenalotto;

public class SuperEnalottoCombinations {

    public static void superEnalottoValues() {
        int[] combination = new int[6];
        for (int z = 1; z <= 85; z++) {
            combination[0] = z;
            for (int x = z + 1; x <= 86 ; x++) {
                combination[1] = x;
                for (int c = x + 1; c <= 87 ; c++) {
                    combination[2] = c;
                    for (int v = c + 1; v <= 88; v++) {
                        combination[3] = v;
                        for (int b = v + 1; b <= 89; b++) {
                            combination[4] = b;
                            for (int n = b + 1; n <= 90; n++) {
                                combination[5] = n;
                                if (sequence(combination) && pairNumber(combination)) {
                                    System.out.println(
                                            combination[0] +
                                                    " " + combination[1]+
                                                    " " + combination[2]+
                                                    " " + combination[3]+
                                                    " " + combination[4]+
                                                    " " + combination[5]);
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    public static boolean sequence(int [] combination) {
        for (int i = 2; i < combination.length; i++)
            if (combination[i] == combination[i - 1] + 1 && combination[i] == combination[i - 2] + 2)
                return true;
        return false;
    }

    public static boolean pairNumber(int [] combination){
        int pairNumber = 0;
        for (int i = 0; i < combination.length; i++) {
            if(combination [i] % 2 == 0)
                pairNumber++;
        }
        if (pairNumber >= 2 && pairNumber <=4)
            return true;
        return false;
    }

    public static void main(String[] args) {
		int[] firstCombination = { 1, 2, 3, 4, 5, 6 };
		int[] secondCombination = { 1, 2, 4, 6, 8, 10 };
		int[] thirdCombination = { 1, 2, 4, 6, 8, 11 };
		int[] fourthCombination = { 1, 2, 4, 7, 6, 9 };
 		System.out.println(" Case numPari 1: " + pairNumber(firstCombination));
		System.out.println(" Case numPari 2: " + pairNumber(secondCombination));
		System.out.println(" Case numPari 3: " + pairNumber(thirdCombination));
		System.out.println(" --------------------- ");
		System.out.println(" Case Seq 1: " + sequence(firstCombination));
		System.out.println(" Case Seq 2: " + sequence(secondCombination));
		System.out.println(" Case Seq 3: " + sequence(thirdCombination));
		System.out.println(" Case Seq 4: " + sequence(fourthCombination));
        superEnalottoValues();
    }
}
