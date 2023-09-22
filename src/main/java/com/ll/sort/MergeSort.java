package com.ll.sort;

public class MergeSort {

    static void merge(int[] arr, int left, int mid, int right){
        int indexL = left; // 분할된 배열 중 왼쪽 배열
        int indexR = mid + 1; //분할된 배열 중 오른쪽 배열
        int index = left; //빈 객체의 인덱스 (left부터 저장해야할 인덱스임)

        int[] tmp = new int[right + 1];

        while(indexL <= mid && indexR <= right){ //왼쪽 배열이나 오른쪽 배열 둘 중 하나가 끝날때까지
            if(arr[indexL] <= arr[indexR]) //오름차순이기 때문에 작은값부터 넣어줘야 한다.
                tmp[index++] = arr[indexL++];
            else
                tmp[index++] = arr[indexR++];
        }

        //남은거 처리
        if(indexL > mid){ //만약 왼쪽 배열이 끝났다면 오른쪽 배열이 남아있다는 뜻
            for(int i=indexR; i<=right; i++){ //나머지 처리
                tmp[index++] = arr[i];
            }
        } else{ //반대로 오른쪽 배열이 끝났다면 왼쪽 배열이 남아있다는 뜻
            for(int i=indexL; i<=mid; i++){ //나머지 처리
                tmp[index++] = arr[i];
            }
        }

        for(int i=left; i<=right; i++){ //정렬된 빈 배열을 원래 배열로 다 옮긴다.
            arr[i] = tmp[i];
        }
    }

    static void mergeSort(int[] arr, int left, int right){
        if(left < right){ //정렬해야될 범위가 있을 때
            int mid = (left + right) / 2; //중간 지점을 기준으로 둘로 나눈다. (log n)

            mergeSort(arr, left, mid); // 왼쪽 범위

            mergeSort(arr, mid+1, right); //오른쪽 범위

            merge(arr, left, mid, right); //왼쪽 오른쪽 나눴으면 빈 배열에 정렬해서 넣어줘야 한다.
        }
    }
    public static void main(String[] args) {
        int[] x = { 5, 7, 1, 4, 6, 2, 3, 9, 8 };

        mergeSort(x, 0, x.length - 1);

        for(int i = 0 ; i < x.length ; i++) {
            System.out.println(x[i]);
        }
    }
}
