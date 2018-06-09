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
        bs.fillSoruce(bs.getSource());
        bs.binarySearch(bs.getSource(), 27);
        System.out.println(bs.getStepCount());
    }


    /*private void binarySearch(int[] src, int item) {
        int prevIndex = 0;
        int index = src.length / 2;
        int tmpIndex = 0;
        int guess = src[index];
        int loopCount = getCountOfLoop(src.length);
        while (guess != item) {
            if (guess > item) {
                if (stepCount == 0) {
                    prevIndex = 0;
                }
                if (stepCount > 0 && stepCount < loopCount) {
                    tmpIndex = index;
                    index = index > prevIndex ? prevIndex + ((index - prevIndex) / 2) : index + ((prevIndex - index) / 2);
                } else {
                    tmpIndex = index;
                    index = index / 2;
                }
                prevIndex = tmpIndex;

                guess = src[index];
                stepCount++;
            } else {
                if (stepCount == 0) {
                    prevIndex = src.length;
                }
                if (stepCount > 0 && stepCount < loopCount) {
                    tmpIndex = index;
                    index = index > prevIndex ? ((index - prevIndex) / 2) + index : ((prevIndex - index) / 2) + prevIndex;
                } else {
                    tmpIndex = index;
                    index = index / 2;
                }
                prevIndex = tmpIndex;
                guess = src[index];
                stepCount++;
            }
        }

    }*/

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
                        /*if (stepCount == 0) {
                            left = src.length / 2;
                            right = src.length;
                        }*/
                        i = src[((right - middle) / 2) + middle];
                        middle = (right - middle) / 2 + middle;
                        guess = src[i];
                        left = middle - (right - middle);
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
