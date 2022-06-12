#pragma once
#include<stdio.h>
#include<assert.h>
#include<malloc.h>
#include<string.h>

//打印数组测试
void PrintArr(int* arr, int size) {
	for (int i = 0; i < size; i++) {
		printf("%d ",arr[i]);
	}
	printf("\n");
}

//直接插入排序
//传入参数是数组的首元素指针以及数组的大小
void InsertSort(int* arr, int size) {
	for (int i = 0; i < size - 1; i++) {
		int endpos = i;//有序子序列的末尾下标
		int next = arr[endpos + 1];
		while (endpos >= 0) {
			if (arr[endpos] > next) {//从小到大排序
				arr[endpos + 1] = arr[endpos];//这个endpos位置的元素向后挪
				endpos--;
			}
			else {
				//找到next该放的位置了,next放到endpos+1位置
				break;
			}
		}
		arr[endpos + 1] = next;
	}
}

//折半插入排序
//传入参数是数组的首元素指针以及数组的大小
int BinarySearch(int* arr, int left, int right, int target) {
	while (left <= right) {
		int mid = (left + right) >> 1;
		if (arr[mid] > target) {
			right = mid - 1;
		}
		else if (arr[mid] < target) {
			left = mid + 1;
		}
		else {
			//相等，保证稳定排序插入到这个元素的下一个位置
			left = mid + 1;
			break;
		}
	}
	return left;
}
void InsertSortUseBisearch(int* arr, int size) {
	for (int i = 0; i < size - 1; i++) {
		int endpos = i;
		int next = arr[endpos + 1];
		//设置折半查找范围[0,endpos]
		int pos = BinarySearch(arr, 0, endpos, next);
		//将pos到endpos的元素进行挪动
		for (int j = endpos; j >= pos; j--) {
			arr[j + 1] = arr[j];
		}
		arr[pos] = next;
	}
}

//希尔排序
//传入参数是数组的首元素指针以及数组的大小
void ShellSort(int* arr, int size) {
	int step = size;//希尔每次处理数组的步长，最后步长为1执行直接插入排序
	while (step > 1) {
		step = step / 3 + 1;//为了让step最小值为1，一定能执行一次直接插入排序
		for (int i = 0; i < size - step; i++) {
			int endpos = i;
			int next = arr[endpos + step];
			while (endpos>=0){
				if (next < arr[endpos]) {
					arr[endpos + step] = arr[endpos];
					endpos -= step;
				}
				else {
					break;
				}
			}
			arr[endpos + step] = next;
		}
	}
}

//冒泡排序
//传入参数是数组的首元素指针以及数组的大小
void swap(int* left, int* right) {
	int tmp = *left;
	*left = *right;
	*right = tmp;
}
void BubbleSort(int* arr, int size) {
	int flag = 0;//标记某次冒泡是否交换顺序
	for (int i = 0; i < size; i++) {
		flag = 0;
		for (int j = 0; j < size - i - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				flag = 1;
				swap(&arr[j], &arr[j + 1]);
			}
		}
		if (flag == 0) {
			//这次遍历没有交换过，数组已经有序了
			break;
		}
	}
}

//快速排序
//传入数组，数组头，数组尾，三数取中,返回中间值的下标,数组区间[]形式
int GetMidIndex(int* arr, int left, int right) {
	int mid = (left + right) >> 1;
	if (arr[left] < arr[mid]) {
		if (arr[mid] < arr[right]) {
			//arr[left]<arr[mid]<arr[right]
			return mid;
		}
		else if (arr[right] > arr[left]) {
			//arr[right]<=arr[mid]
			//arr[left]<arr[right]<=arr[mid]
			return right;
		}
		else {
			//arr[right]<=arr[mid]
			//arr[right]<=arr[left]
			//arr[right]<=arr[left]<arr[mid]
			return left;
		}
	}
	else {//arr[left]>arr[mid]
		if (arr[mid] > arr[right]) {
			//arr[right]<arr[mid]<arr[left]
			return mid;
		}
		else if (arr[right] > arr[left]) {
			//arr[mid]<arr[left]<arr[right]
			return left;
		}
		else {
			//arr[mid]<arr[left]
			//arr[right]>=arr[mid]
			//arr[right]<=arr[left]
			//arr[mid]<arr[right]<arr[left]
			return right;
		}
	}
}
//让数组分成三部分，<key key <key,函数返回key值在数组的下标，方便调用方将数组分成两部分
//传入数组的区间为[]
int HoareLeftRightPtr(int* arr, int left, int right) {
	int mid = GetMidIndex(arr, left, right);//key值的下标
	//把key放到最左边可以更方便的交换
	swap(&arr[left], &arr[mid]);
	int keypos = left;
	while (left < right) {
		while (arr[right] >= arr[keypos] && right > left) {
			//找小于key的位置,注意是>=否则会死循环，一直会交换两个值等于keypos
			right--;
		}
		while (arr[left] <= arr[keypos] && left < right) {
			//找大于key的位置
			left++;
		}
		swap(&arr[left], &arr[right]);
	}
	//这时left位置对应的值一定小于key值,就把key放到left这个位置上
	swap(&arr[left], &arr[keypos]);
	return left;
}
//让数组分成三部分，<key key <key,函数返回key值在数组的下标，方便调用方将数组分成两部分
//传入数组的区间为[]
int PitExchangeMethod(int* arr, int left, int right) {
	int mid = GetMidIndex(arr, left, right);//key值的下标
	swap(&arr[left], &arr[mid]);
	//开始最左边是坑，此时这个位置保存的是key值，记录一下key值
	int key = arr[left];
	while (left < right) {
		while (arr[right] >= key && right > left) {
			right--;
		}
		arr[left] = arr[right];//此时right的这个位置成了新的坑
		while (arr[left] <= key && left < right) {
			//找大
			left++;
		}
		arr[right] = arr[left];
	}
	//left位置一定坑,left+1位置大于key，left-1位置小于key
	arr[left] = key;
	return left;
}
//让数组分成三部分，<key key <key,函数返回key值在数组的下标，方便调用方将数组分成两部分
//传入数组的区间为[]
int PrevNextPtr(int* arr, int left, int right) {
	int mid = GetMidIndex(arr, left, right);//key的下标
	swap(&arr[left], &arr[mid]);
	int keypos = left;
	int prev = left;
	int next = prev + 1;
	while (next <= right) {//因为数组区间为[],所以next=right时也要进行判断
		//next找比key值小的位置
		if (arr[keypos] > arr[next]) {
			prev++;
			if (prev != next) {
				swap(&arr[prev], &arr[next]);
			}
		}
		next++;
	}
	swap(&arr[prev], &arr[keypos]);
	return prev;
}
//数组区间为[]
void _QuickSortRecursion(int* arr, int left, int right) {
	if (right - left > 5) {//数组的长度大于5的时候使用快速排序
		int keypos = PrevNextPtr(arr, left, right);
		//int keypos = PitExchangeMethod(arr, left, right);
		//int keypos = HoareLeftRightPtr(arr, left, right);
		//三种移动方法任意选取
		_QuickSortRecursion(arr, left, keypos - 1);
		_QuickSortRecursion(arr, keypos + 1, right);
	}
	else {
		//递归到长度小于5时使用折半插入排序
		InsertSortUseBisearch(arr + left, right - left + 1);
	}
}
//传入参数是数组的首元素指针以及数组的大小
void QuickSort(int* arr, int size) {
	_QuickSortRecursion(arr,0,size-1);
}

//选择排序
//传入数组，以及数组大小
void SelectSort(int* arr, int size) {
	int left = 0; int right = size - 1;
	//这里为了高效，每次选择最大值和最小值放到数组两端
	while (left < right) {
		int maxpos = left; int minpos = left;
		for (int i = left; i <= right; i++) {//数组为[]型
			if (arr[i] < arr[minpos]) {
				minpos = i;
			}
			else if (arr[i] > arr[maxpos]) {
				maxpos = i;
			}
		}
		swap(&arr[left], &arr[minpos]);
		//注意如果最大值在最左边，交换后此位置放的是最小值，最大值的位置改变到原最小值位置，要更新一下坐标
		if (maxpos == left) {
			maxpos = minpos;
		}
		swap(&arr[right], &arr[maxpos]);
		left++; right--;
	}
}

//堆排序
//传入数组，从哪里开始调整堆，堆的大小
void AdjustDown(int* arr, int root, int capcity) {
	int child = 2 * root + 1;
	while (child < capcity) {
		if (child + 1 < capcity && arr[child] < arr[child + 1]) {
			child++;
		}
		if (arr[child] > arr[root]) {
			swap(&arr[child], &arr[root]);
		}
		else {
			break;
		}
		root = child;
		child = 2 * root + 1;
	}
}
//传入数组，及数组大小,从小到大，建立大堆
void HeapSort(int* arr, int size) {
	//建堆,从最后一颗子树开始建堆,建堆时间复杂度为O(N)
	for (int parent = (size - 1 - 1) / 2; parent >= 0; parent--) {
		AdjustDown(arr, parent, size);
	}
	int end = size;
	while (end > 0) {//一次调整对比logN次
		swap(&arr[0], &arr[end - 1]);
		end--;
		AdjustDown(arr, 0, end);
	}
}

//归并排序
//传入数组，以及分割的两个数组的起始位置和最终位置，子数组范围[]
//递归到这里[leftBegin,leftEnd][rightBegin,rightEnd]是两个有序区间
//要让[leftBegin,rightEnd]变为有序
void Merge(int* arr, int* buff, int leftBegin, int leftEnd, int rightBegin, int rightEnd) {
	int buffpos = 0;
	//需要拷贝的数组下标范围
	int begin = leftBegin; int end = rightEnd;
	while (leftBegin <= leftEnd && rightBegin <= rightEnd) {
		if (arr[leftBegin] <= arr[rightBegin]) {
			buff[buffpos++] = arr[leftBegin++];
		}
		else {
			buff[buffpos++] = arr[rightBegin++];
		}
	}
	while (leftBegin <= leftEnd) {
		buff[buffpos++] = arr[leftBegin++];
	}
	while (rightBegin <= rightEnd) {
		buff[buffpos++] = arr[rightBegin++];
	}
	for (int i = begin; i <= end; i++) {
		arr[i] = buff[i - begin];
	}
}
void _MergeSort(int* arr, int* buff, int left, int right) {
	if (left >= right) {
		//递归结束条件
		return;
	}
	int mid = (left + right) >> 1;
	_MergeSort(arr, buff, left, mid);
	_MergeSort(arr, buff, mid + 1, right);
	Merge(arr, buff, left, mid, mid + 1, right);
}
//传入数组，数组大小
void MergeSort(int* arr, int size) {
	int* buff = (int*)malloc(size * sizeof(int));
	assert(buff);
	_MergeSort(arr, buff, 0, size - 1);
	free(buff);
}

//归并排序非递归实现
//传入数组，数组大小
void MergeSortNotRecursion(int* arr, int size) {
	int* buff = (int*)malloc(size * sizeof(int));
	assert(buff);//<assert.h>
	int step = 1;//开始归并区间为1
	while (step < size) {
		for (int i = 0; i < size; i += 2 * step) {
			//左子数组[i,i+step-1]  右子数组[i+step,i+2*step-1]
			int leftbegin = i; int leftend = i + step - 1;
			int rightbegin = i + step; int rightend = i + 2 * step - 1;
			//右子数组可能不存在，即i+step>size，不需要继续这次归并了
			//右子数组可能存在一部分，即i+2*step-1>size，需要缩小右子数组的范围继续归并
			//左子数组可能存在一部分，即i+step-1>size，不需要继续这次归并了
			//左子数组一定存在。进入循环i < size一定成立
			if (rightbegin >= size) {
				//右子数组不存在
				break;
			}
			//右子数组存在
			if (rightend >= size) {
				// 右子数组存在一部分
				rightend = size - 1;//Merge传入数组范围是[]的
			}
			Merge(arr, buff, leftbegin, leftend, rightbegin, rightend);
		}
		step *= 2;
	}
	free(buff);
}

//计数排序
//传入数组，数组大小
void CoutSort(int* arr, int size) {
	int maxVal = arr[0]; int minVal = arr[0];
	//遍历数组找最大值，最小值
	for (int i = 0; i < size; i++) {
		if (arr[i] < minVal) {
			minVal = arr[i];
		}
		else if (arr[i] > maxVal) {
			maxVal = arr[i];
		}
	}
	int capcity = maxVal - minVal + 1;//新开数组的大小
	int* buff = (int*)malloc(sizeof(int) * capcity);
	assert(buff);
	memset(buff, 0, sizeof(int) * capcity);
	for (int i = 0; i < size; i++) {
		buff[arr[i] - minVal]++;//统计数字出现的次数
	}
	int arrpos = 0;
	for (int i = 0; i < capcity; i++) {
		//将数据写回
		while (buff[i]--) {
			arr[arrpos++] = i + minVal;
		}
	}
	free(buff);
}