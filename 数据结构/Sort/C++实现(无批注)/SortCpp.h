#pragma once
#include<vector>
#include<iostream>
#include<algorithm>
#include<stack>

void PrintVetor(std::vector<int>& vet) {
	for (auto num : vet) {
		std::cout << num << " ";
	}
	std::cout << std::endl;
}

//��С��������
class Sort {
public:
	//ֱ�Ӳ�������
	static void InsertSort(std::vector<int>&vet) {
		for (int i = 0; i < vet.size() - 1; i++) {
			int endpos = i;
			int next = vet[endpos + 1];
			while (endpos >= 0) {
				if (vet[endpos] > next) {
					vet[endpos + 1] = vet[endpos];
					endpos--;
				}
				else {
					break;
				}
			}
			vet[endpos + 1] = next;
		}
	}
	//�۰��������
	static void InsertSortUseBisearch(std::vector<int>& vet) {
		for (int i = 0; i < vet.size() - 1; i++) {
			int endpos = i;
			int next = vet[endpos + 1];
			std::vector<int>::iterator findpos = std::upper_bound(vet.begin(), vet.begin() + endpos + 1, next); //���ֲ����ҵ�һ������nextλ��
			for (auto pos = vet.begin() + endpos; pos >= findpos; pos--) {
				if (pos == vet.begin()) {//C++����������Ϊ������posָ��ͷʱ�������һ�ο���
					*(pos + 1) = *pos;
					break;
				}
				*(pos + 1) = *pos;
			}
			*findpos = next;
		}
	}
	//ϣ������
	static void ShellSort(std::vector<int>& vet) {
		int step = vet.size();
		while (step > 1) {
			step = step / 3 + 1;
			for (int i = 0; i < vet.size() - step; i++) {
				int endpos = i;
				int next = vet[endpos + step];
				while (endpos >= 0) {
					if (vet[endpos] > next) {
						vet[endpos + step] = vet[endpos];
						endpos -= step;
					}
					else {
						break;
					}
				}
				vet[endpos + step] = next;
			}
		}
	}
	//ð������
	static void BubbleSort(std::vector<int>& vet) {
		for (int i = 0; i < vet.size(); i++) {
			bool flag = false;//����Ƿ�������
			for (int j = 0; j < vet.size() - i - 1; j++) {
				if (vet[j] > vet[j + 1]) {
					flag = true;
					std::swap(vet[j], vet[j + 1]);
				}
			}
			if (flag == false) {
				break;
			}
		}
	}
	//��������
private:
	//keyֵ��ѡȡ������ȡ�У�
	static int GetMidPos(std::vector<int>& vet, int leftpos, int rightpos) {
		int midpos = (leftpos + rightpos) >> 1;
		if (vet[leftpos] < vet[midpos]) {
			if (vet[midpos] < vet[rightpos]) {
				return midpos;
			}
			else if (vet[rightpos] > vet[leftpos]) {
				return rightpos;
			}
			else {
				return leftpos;
			}
		}
		else {
			if (vet[rightpos] < vet[midpos]) {
				return midpos;
			}
			else if (vet[leftpos] < vet[rightpos]) {
				return leftpos;
			}
			else {
				return rightpos;
			}
		}
	}
	//���ֽ�������,��������keyֵ��������±�
	//ǰ��ָ�뷨
	static int HoareLeftRightPtr(std::vector<int>& vet, int left, int right) {
		int midpos = GetMidPos(vet, left, right);
		std::swap(vet[midpos], vet[left]);//��keyֵ�ŵ����������
		int keypos = left; int key = vet[keypos];
		while (left < right) {
			while (vet[right] >= key && right > left) {
				right--;
			}
			while (vet[left] <= key && left < right) {
				left++;
			}
			std::swap(vet[left], vet[right]);
		}
		std::swap(vet[left], vet[keypos]);
		return left;
	}
	//�ڿӷ�
	static int PitExchangeMethod(std::vector<int>& vet, int left, int right) {
		int midpos = GetMidPos(vet, left, right);
		std::swap(vet[left], vet[midpos]);
		int key = vet[left];
		//��ʼleftΪ��
		while (left < right) {
			while (vet[right] >= key && left < right) {
				right--;
			}
			vet[left] = vet[right];
			while (vet[left] <= key && left < right) {
				left++;
			}
			vet[right] = vet[left];
		}
		//leftλ��һ��Ϊ��
		vet[left] = key;
		return left;
	}
	//ǰ��ָ�뷨
	static int PrevNextPtr(std::vector<int>& vet, int left, int right) {
		int midpos = GetMidPos(vet, left, right);
		std::swap(vet[left], vet[midpos]);
		int keypos = left;
		int prev = left;
		int next = prev + 1;//��С
		while (next <= right) {
			if (vet[next] < vet[keypos]) {
				prev++;
				if (prev != next) {
					std::swap(vet[prev], vet[next]);
				}
			}
			next++;
		}
		std::swap(vet[prev], vet[keypos]);
		return prev;
	}
	static void _QuickSort(std::vector<int>& vet, int left, int right) {
		if (left >= right) {
			return;
		}
		/*int keypos = PrevNextPtr(vet, left, right);*/
		/*int keypos = HoareLeftRightPtr(vet, left, right);*/
		int keypos = PitExchangeMethod(vet, left, right);
		_QuickSort(vet, left, keypos - 1);
		_QuickSort(vet, keypos + 1, right);
	}
public:
	static void QuickSort(std::vector<int>& vet) {
		_QuickSort(vet, 0, vet.size() - 1);
	}
	
	//��������ǵݹ�
	static void QuickSortNotRecursive(std::vector<int>& vet) {
		//ջ�ϵ�ÿ��Ԫ�ض���һ������[left,right]
		std::stack<std::vector<int>>st;
		st.push({ 0,static_cast<int>(vet.size() - 1) });
		while (!st.empty()) {
			std::vector<int>range = st.top(); st.pop();
			int keypos = HoareLeftRightPtr(vet, range[0], range[1]);
			if (range[0] < keypos - 1) {
				st.push({ range[0],keypos - 1 });
			}
			if (keypos + 1 < range[1]) {
				st.push({ keypos + 1,range[1] });
			}
		}
	}

	//ѡ������
	static void SelectSort(std::vector<int>& vet) {
		int left = 0; int right = vet.size() - 1;
		while (left < right) {
			int maxpos = left; int minpos = left;
			for (int i = left; i <= right; i++) {
				if (vet[i] > vet[maxpos]) {
					maxpos = i;
				}
				else if (vet[i] < vet[minpos]) {
					minpos = i;
				}
			}
			std::swap(vet[left], vet[minpos]);
			if (maxpos == left) {
				maxpos = minpos;
			}
			std::swap(vet[maxpos], vet[right]);
			left++; right--;
		}
	}

	//������,��С�������򣬽������
private:
	static void AdjustDown(std::vector<int>& vet, int parent, int capcity) {
		int child = 2 * parent + 1;
		while (child < capcity) {
			if (child + 1 < capcity && vet[child + 1] > vet[child]) {
				child++;
			}
			if (vet[parent] < vet[child]) {
				std::swap(vet[parent], vet[child]);
			}
			else {
				break;
			}
			parent = child;
			child = 2 * parent + 1;
		}
	}
public:
	static void HeapSort(std::vector<int>&vet) {
		//����
		for (int i = (vet.size() - 1 - 1) / 2; i >= 0; i--) {
			AdjustDown(vet, i,vet.size());
		}
		int end = vet.size();
		while (end > 0) {
			std::swap(vet[0], vet[end - 1]);
			end--;
			AdjustDown(vet, 0, end);
		}
	}

	//�鲢����
private:
	static void Merge(std::vector<int>& vet, std::vector<int>& buff, int leftfirst, int leftend, int rightfirst, int rightend) {
		int buffpos = 0;
		int begin = leftfirst; int end = rightend;
		while (leftfirst <= leftend && rightfirst <= rightend) {
			if (vet[leftfirst] <= vet[rightfirst]) {
				buff[buffpos++] = vet[leftfirst++];
			}
			else {
				buff[buffpos++] = vet[rightfirst++];
			}
		}
		while (leftfirst <= leftend) {
			buff[buffpos++] = vet[leftfirst++];
		}
		while (rightfirst <= rightend) {
			buff[buffpos++] = vet[rightfirst++];
		}
		for (int i = begin; i <= end; i++) {
			vet[i] = buff[i - begin];
		}
	}
	static void _MergeSort(std::vector<int>& vet, std::vector<int>buff, int left, int right) {//[]
		if (left >= right) {
			return;
		}
		int mid = (left + right) >> 1;
		_MergeSort(vet, buff, left, mid);
		_MergeSort(vet, buff, mid + 1, right);
		Merge(vet, buff, left, mid, mid + 1, right);

	}
public:
	static void MergeSort(std::vector<int>& vet) {
		std::vector<int>buff(vet.size());
		_MergeSort(vet, buff, 0, vet.size() - 1);
	}

	//�鲢����ǵݹ�
	static void MergeSortNotRecursion(std::vector<int>& vet) {
		int step = 1;
		std::vector<int>buff(vet.size());
		while (step < vet.size()) {
			for (int i = 0; i < vet.size(); i += 2 * step) {
				int leftfirst = i; int leftend = i + step - 1;
				int rightfirst = i + step; int rightend = i + 2 * step - 1;
				if (rightfirst >= vet.size()) {
					//û��������ֹͣ�鲢
					break;
				}
				if (rightend >= vet.size()) {
					rightend = vet.size() - 1;
				}
				Merge(vet, buff, leftfirst, leftend, rightfirst, rightend);
			}
			step *= 2;
		}
	}

	//��������
	static void CoutSort(std::vector<int>& vet) {
		int max = *std::max_element(vet.begin(), vet.end());
		int min = *std::min_element(vet.begin(), vet.end());
		std::vector<int>count(max - min + 1, 0);
		for (int i = 0; i < vet.size(); i++) {
			count[vet[i] - min]++;
		}
		int vetpos = 0;
		for (int i = 0; i < count.size(); i++) {
			while (count[i]--) {
				vet[vetpos++] = i + min;
			}
		}
	}
};
