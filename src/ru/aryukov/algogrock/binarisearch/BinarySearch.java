package ru.aryukov.algogrock.binarisearch;

public class BinarySearch {
    private int[] source = new int[100];
    private int stepCount = 0;

    public int[] getSource() {
        return source;
    }

    public int getStepCount() {
        return stepCount;
    }


    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        for (int i = 1 ; i < 100; i++){
            bs.fillSoruce(bs.getSource());
            System.out.println("Ищем:" + i);
            bs.binarySearch(bs.getSource(), i);
            System.out.println("Найдено за " + bs.getStepCount() + " итераций");
            bs.stepCount = 0;
        }
    }


    public void binarySearch(int[] src, int item) {
        int left = 0;
        int middle = src.length / 2;
        int right = src.length;
        int i = src.length / 2;
        int guess = src[i];
        int loopCount = getCountOfLoop(src.length);

        while (guess != item) {
            if (stepCount < loopCount) {
                while (stepCount != loopCount) {
                    if (guess > item) {
                        i = src[(middle - left) / 2 + left];
                        middle = (middle - left) / 2 + left;
                        guess = src[i];
                        right = middle + (middle  - left);
                        stepCount++;
                    } else {
                        i = src[((right - middle) / 2) + middle];
                        middle = (right - middle) / 2 + middle;
                        left = middle - (right - middle);
                        guess = src[i];
                        stepCount++;
                    }
                }
            } else {
                if (guess > item) {
                    i--;
                    guess = src[i];
                    stepCount++;
                } else {
                    i++;
                    guess = src[i];
                    stepCount++;
                }
            }
        }
        System.out.println("Искомое значение:" + guess);
    }

    private int getCountOfLoop(int arrSize) {
        return (int) Math.log(arrSize);
    }

    private void fillSoruce(int[] s) {
        for (int i = 0; i < s.length; i++) {
            s[i] = i;
        }
    }
}
