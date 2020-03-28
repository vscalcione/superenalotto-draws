package it.estrazioni.superenalotto;

public class CombinationsSuperEnalotto {

    public static void superEnalottoNumbers(){
        int[] combination = new int[6];
        for (int i = 0; i <= 85; i++) {
            combination[0] = i;
            for (int j = i + 1; j <=86; j++) {
                combination[1] = j;
                for (int k = j + 1; k <= 87; k++) {
                    combination[2] = k;
                    for (int l = k + 1; l <= 88; l++) {
                        combination[3] = l;
                        for (int m = l + 1; m <= 89; m++) {
                            combination[4] = m;
                            for (int n = m + 1; n <= 90; n++) {
                                combination[5] = n;
                                if (sequence(combination) && pairNumbers(combination)) {
                                    System.out.println(
                                            combination[0] +
                                                    " " + combination[1]+
                                                    " " + combination[2]+
                                                    " " + combination[3]+
                                                    " " + combination[4]+
                                                    " " + combination[5]
                                    );
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean sequence (int [] combination) {
        for (int i = 2; i < combination.length; i++){
            if (combination[i] == combination[i - 1] + 1 && combination[i] == combination[i - 2] + 2)
                return true;
        }
        return false;
    }

    public static boolean pairNumbers (int [] combinazione){
        int pairNumber = 0;
        for (int i = 0; i < combinazione.length; i++) {
            if(combinazione [i] % 2 == 0)
                pairNumber++;
        }
        if (pairNumber >= 2 && pairNumber <=4)
            return true;
        return false;
    }

//    public static void main(String[] args) {
//        int[] firstCombination = {1, 2, 3, 4, 5, 6};
//        int[] secondCombination = {1, 2, 4, 6, 8, 10};
//        int[] thirdCombination = {1, 2, 4, 6, 8, 11};
//        int[] fourthCombination = {1, 2, 4, 7, 6, 9};
//        System.out.println("Case 1st pair numbers: " + pairNumbers(firstCombination));
//        System.out.println("Case 2nd pair numbers: " + pairNumbers(secondCombination));
//        System.out.println("Case 3rd pair numbers: " + pairNumbers(thirdCombination));
//        System.out.println("---------------------");
//        System.out.println("Case 1st sequence: " + sequence(firstCombination));
//        System.out.println("Case 2nd sequence: " + sequence(secondCombination));
//        System.out.println("Case 3rd sequence: " + sequence(thirdCombination));
//        System.out.println("Case 4th sequence: " + sequence(fourthCombination));
//        superEnalottoNumbers();
//    }
}
