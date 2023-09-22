package com.ll.sort;

public class QuickSort {
    private static void swap(int[] a, int i, int j) { // 인덱스 i,j 의 위치를 교환하는 함수
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void quickSort(int[] arr, int left, int right){ //실제 정렬 함수
        int pl = left; //왼쪽 커서
        int pr = right; //오른쪽 커서
        int pivot = arr[(left+right) / 2]; //피벗은 중앙값으로 지정 (왼쪽, 오른쪽 피벗이 모두 가능하다.)

        do{
            while(arr[pl] < pivot) pl++; //피벗보다 큰 값을 찾을때까지 왼쪽 커서 오른쪽으로 이동
            while(arr[pr] > pivot) pr--; //피벗보다 작은 값을 찾을때까지 오른쪽 커서 왼쪽으로 이동
            if(pl<=pr) //여기에 도달했을때는 피벗을 기준으로 왼쪽 커서는 피벗보다 큰 값을, 오른쪽 커서는 피벗보다 작은 값을 가르킨다.
                swap(arr, pl++, pr--); // 두 데이터를 교환해준다.
        }while(pl<=pr); //두 커서가 어긋날때까지 반복한다. (여기서 안멈추면 다시 제자리로 바뀐다)

        if(left < pr) quickSort(arr, left, pr); //pr이 left보다 크다는 것은 왼쪽에 아직 손대지 못한 데이터가 남았다는 뜻
        if(pl < right) quickSort(arr, pl, right ); //pl이 right보다 작다는 것은 오른쪽에 손대지 못한 데이터가 남았다는 뜻
        //남은 데이터들을 각각의 범위로 쪼개서 분할 정복을 진행한다.

    }

    public static void main(String[] args) {
        int[] x = { 5, 7, 1, 4, 6, 2, 3, 9, 8 };

        quickSort(x, 0, x.length - 1);

        for(int i = 0 ; i < x.length ; i++) {
            System.out.println(x[i]);
        }
    }
}
