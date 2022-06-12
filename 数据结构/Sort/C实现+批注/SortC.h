#pragma once
#include<stdio.h>
#include<assert.h>
#include<malloc.h>
#include<string.h>

//��ӡ�������
void PrintArr(int* arr, int size) {
	for (int i = 0; i < size; i++) {
		printf("%d ",arr[i]);
	}
	printf("\n");
}

//ֱ�Ӳ�������
//����������������Ԫ��ָ���Լ�����Ĵ�С
void InsertSort(int* arr, int size) {
	for (int i = 0; i < size - 1; i++) {
		int endpos = i;//���������е�ĩβ�±�
		int next = arr[endpos + 1];
		while (endpos >= 0) {
			if (arr[endpos] > next) {//��С��������
				arr[endpos + 1] = arr[endpos];//���endposλ�õ�Ԫ�����Ų
				endpos--;
			}
			else {
				//�ҵ�next�÷ŵ�λ����,next�ŵ�endpos+1λ��
				break;
			}
		}
		arr[endpos + 1] = next;
	}
}

//�۰��������
//����������������Ԫ��ָ���Լ�����Ĵ�С
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
			//��ȣ���֤�ȶ�������뵽���Ԫ�ص���һ��λ��
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
		//�����۰���ҷ�Χ[0,endpos]
		int pos = BinarySearch(arr, 0, endpos, next);
		//��pos��endpos��Ԫ�ؽ���Ų��
		for (int j = endpos; j >= pos; j--) {
			arr[j + 1] = arr[j];
		}
		arr[pos] = next;
	}
}

//ϣ������
//����������������Ԫ��ָ���Լ�����Ĵ�С
void ShellSort(int* arr, int size) {
	int step = size;//ϣ��ÿ�δ�������Ĳ�������󲽳�Ϊ1ִ��ֱ�Ӳ�������
	while (step > 1) {
		step = step / 3 + 1;//Ϊ����step��СֵΪ1��һ����ִ��һ��ֱ�Ӳ�������
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

//ð������
//����������������Ԫ��ָ���Լ�����Ĵ�С
void swap(int* left, int* right) {
	int tmp = *left;
	*left = *right;
	*right = tmp;
}
void BubbleSort(int* arr, int size) {
	int flag = 0;//���ĳ��ð���Ƿ񽻻�˳��
	for (int i = 0; i < size; i++) {
		flag = 0;
		for (int j = 0; j < size - i - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				flag = 1;
				swap(&arr[j], &arr[j + 1]);
			}
		}
		if (flag == 0) {
			//��α���û�н������������Ѿ�������
			break;
		}
	}
}

//��������
//�������飬����ͷ������β������ȡ��,�����м�ֵ���±�,��������[]��ʽ
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
//������ֳ������֣�<key key <key,��������keyֵ��������±꣬������÷�������ֳ�������
//�������������Ϊ[]
int HoareLeftRightPtr(int* arr, int left, int right) {
	int mid = GetMidIndex(arr, left, right);//keyֵ���±�
	//��key�ŵ�����߿��Ը�����Ľ���
	swap(&arr[left], &arr[mid]);
	int keypos = left;
	while (left < right) {
		while (arr[right] >= arr[keypos] && right > left) {
			//��С��key��λ��,ע����>=�������ѭ����һֱ�ύ������ֵ����keypos
			right--;
		}
		while (arr[left] <= arr[keypos] && left < right) {
			//�Ҵ���key��λ��
			left++;
		}
		swap(&arr[left], &arr[right]);
	}
	//��ʱleftλ�ö�Ӧ��ֵһ��С��keyֵ,�Ͱ�key�ŵ�left���λ����
	swap(&arr[left], &arr[keypos]);
	return left;
}
//������ֳ������֣�<key key <key,��������keyֵ��������±꣬������÷�������ֳ�������
//�������������Ϊ[]
int PitExchangeMethod(int* arr, int left, int right) {
	int mid = GetMidIndex(arr, left, right);//keyֵ���±�
	swap(&arr[left], &arr[mid]);
	//��ʼ������ǿӣ���ʱ���λ�ñ������keyֵ����¼һ��keyֵ
	int key = arr[left];
	while (left < right) {
		while (arr[right] >= key && right > left) {
			right--;
		}
		arr[left] = arr[right];//��ʱright�����λ�ó����µĿ�
		while (arr[left] <= key && left < right) {
			//�Ҵ�
			left++;
		}
		arr[right] = arr[left];
	}
	//leftλ��һ����,left+1λ�ô���key��left-1λ��С��key
	arr[left] = key;
	return left;
}
//������ֳ������֣�<key key <key,��������keyֵ��������±꣬������÷�������ֳ�������
//�������������Ϊ[]
int PrevNextPtr(int* arr, int left, int right) {
	int mid = GetMidIndex(arr, left, right);//key���±�
	swap(&arr[left], &arr[mid]);
	int keypos = left;
	int prev = left;
	int next = prev + 1;
	while (next <= right) {//��Ϊ��������Ϊ[],����next=rightʱҲҪ�����ж�
		//next�ұ�keyֵС��λ��
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
//��������Ϊ[]
void _QuickSortRecursion(int* arr, int left, int right) {
	if (right - left > 5) {//����ĳ��ȴ���5��ʱ��ʹ�ÿ�������
		int keypos = PrevNextPtr(arr, left, right);
		//int keypos = PitExchangeMethod(arr, left, right);
		//int keypos = HoareLeftRightPtr(arr, left, right);
		//�����ƶ���������ѡȡ
		_QuickSortRecursion(arr, left, keypos - 1);
		_QuickSortRecursion(arr, keypos + 1, right);
	}
	else {
		//�ݹ鵽����С��5ʱʹ���۰��������
		InsertSortUseBisearch(arr + left, right - left + 1);
	}
}
//����������������Ԫ��ָ���Լ�����Ĵ�С
void QuickSort(int* arr, int size) {
	_QuickSortRecursion(arr,0,size-1);
}

//ѡ������
//�������飬�Լ������С
void SelectSort(int* arr, int size) {
	int left = 0; int right = size - 1;
	//����Ϊ�˸�Ч��ÿ��ѡ�����ֵ����Сֵ�ŵ���������
	while (left < right) {
		int maxpos = left; int minpos = left;
		for (int i = left; i <= right; i++) {//����Ϊ[]��
			if (arr[i] < arr[minpos]) {
				minpos = i;
			}
			else if (arr[i] > arr[maxpos]) {
				maxpos = i;
			}
		}
		swap(&arr[left], &arr[minpos]);
		//ע��������ֵ������ߣ��������λ�÷ŵ�����Сֵ�����ֵ��λ�øı䵽ԭ��Сֵλ�ã�Ҫ����һ������
		if (maxpos == left) {
			maxpos = minpos;
		}
		swap(&arr[right], &arr[maxpos]);
		left++; right--;
	}
}

//������
//�������飬�����￪ʼ�����ѣ��ѵĴ�С
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
//�������飬�������С,��С���󣬽������
void HeapSort(int* arr, int size) {
	//����,�����һ��������ʼ����,����ʱ�临�Ӷ�ΪO(N)
	for (int parent = (size - 1 - 1) / 2; parent >= 0; parent--) {
		AdjustDown(arr, parent, size);
	}
	int end = size;
	while (end > 0) {//һ�ε����Ա�logN��
		swap(&arr[0], &arr[end - 1]);
		end--;
		AdjustDown(arr, 0, end);
	}
}

//�鲢����
//�������飬�Լ��ָ�������������ʼλ�ú�����λ�ã������鷶Χ[]
//�ݹ鵽����[leftBegin,leftEnd][rightBegin,rightEnd]��������������
//Ҫ��[leftBegin,rightEnd]��Ϊ����
void Merge(int* arr, int* buff, int leftBegin, int leftEnd, int rightBegin, int rightEnd) {
	int buffpos = 0;
	//��Ҫ�����������±귶Χ
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
		//�ݹ��������
		return;
	}
	int mid = (left + right) >> 1;
	_MergeSort(arr, buff, left, mid);
	_MergeSort(arr, buff, mid + 1, right);
	Merge(arr, buff, left, mid, mid + 1, right);
}
//�������飬�����С
void MergeSort(int* arr, int size) {
	int* buff = (int*)malloc(size * sizeof(int));
	assert(buff);
	_MergeSort(arr, buff, 0, size - 1);
	free(buff);
}

//�鲢����ǵݹ�ʵ��
//�������飬�����С
void MergeSortNotRecursion(int* arr, int size) {
	int* buff = (int*)malloc(size * sizeof(int));
	assert(buff);//<assert.h>
	int step = 1;//��ʼ�鲢����Ϊ1
	while (step < size) {
		for (int i = 0; i < size; i += 2 * step) {
			//��������[i,i+step-1]  ��������[i+step,i+2*step-1]
			int leftbegin = i; int leftend = i + step - 1;
			int rightbegin = i + step; int rightend = i + 2 * step - 1;
			//����������ܲ����ڣ���i+step>size������Ҫ������ι鲢��
			//����������ܴ���һ���֣���i+2*step-1>size����Ҫ��С��������ķ�Χ�����鲢
			//����������ܴ���һ���֣���i+step-1>size������Ҫ������ι鲢��
			//��������һ�����ڡ�����ѭ��i < sizeһ������
			if (rightbegin >= size) {
				//�������鲻����
				break;
			}
			//�����������
			if (rightend >= size) {
				// �����������һ����
				rightend = size - 1;//Merge�������鷶Χ��[]��
			}
			Merge(arr, buff, leftbegin, leftend, rightbegin, rightend);
		}
		step *= 2;
	}
	free(buff);
}

//��������
//�������飬�����С
void CoutSort(int* arr, int size) {
	int maxVal = arr[0]; int minVal = arr[0];
	//�������������ֵ����Сֵ
	for (int i = 0; i < size; i++) {
		if (arr[i] < minVal) {
			minVal = arr[i];
		}
		else if (arr[i] > maxVal) {
			maxVal = arr[i];
		}
	}
	int capcity = maxVal - minVal + 1;//�¿�����Ĵ�С
	int* buff = (int*)malloc(sizeof(int) * capcity);
	assert(buff);
	memset(buff, 0, sizeof(int) * capcity);
	for (int i = 0; i < size; i++) {
		buff[arr[i] - minVal]++;//ͳ�����ֳ��ֵĴ���
	}
	int arrpos = 0;
	for (int i = 0; i < capcity; i++) {
		//������д��
		while (buff[i]--) {
			arr[arrpos++] = i + minVal;
		}
	}
	free(buff);
}