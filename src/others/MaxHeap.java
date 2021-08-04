package others;

/**
 * @author lizhongjie
 * @desc 最大堆 最大/最小堆的前提就是 完全二叉树
 * 构造最大堆
 * 向最大堆中插入
 * 向最大堆中删除
 * @create_time 2021/8/3
 */
public class MaxHeap {

    private int[] heap;

    private int size;

    private int maxSize;


    /**
     * 构造一个为空的最大堆
     * maxSize为这个堆的最大容量
     * size为堆的当前个数索引
     * heap维护了当前堆内的元素
     * 为了表示方便 数组下标从1开始 故heap的最大容量为maxSize+1
     *
     * @param maxSize
     */
    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    /**
     * 返回这个位置的父亲节点的位置
     * 如果数组从0开始 则父节点为 (i-1)/2
     *
     * @param pos
     * @return
     */
    private int parent(int pos) {
        return pos / 2;
    }

    /**
     * 返回某个位置的父节点的位置 数组位置从0开始
     * @param pos
     * @return
     */
    private int parentFromZero(int pos) {
        return (pos - 1) / 2;
    }


    /**
     * 返回左子节点的位置
     * 如果数组从0开始 则左子节点为（2i+1）
     *
     * @param pos
     * @return
     */
    private int leftChild(int pos) {
        return (2 * pos);
    }

    /**
     * 返回左子节点的位置
     * 数组位置从0开始
     * @param pos
     * @return
     */
    private int leftChildFromZero(int pos){
        return (2 * pos) +1;
    }

    /**
     * 返回右子节点的位置
     * 如果数组从0开始 则右子节点为（2i+2）
     *
     * @param pos
     * @return
     */
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    /**
     * 返回右子节点的位置
     * 数组位置从0开始
     *
     * @param pos
     * @return
     */
    private int rightChildFromZero(int pos) {
        return (2 * pos) + 2;
    }

    /**
     * 判断给定位置的节点是否为叶子节点
     * 如果数组从0开始 则判断方式为 pos * 2 + 1> size && pos < size
     *
     * @param pos
     * @return
     */
    private boolean isLeaf(int pos) {
        // 意为： pos * 2 > size && pos <= size pos * 2 > size 表示不存在左子节点 则一定为叶子节点
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    /**
     * 交换两个位置的节点值
     *
     * @param leftPos  第一个交换的值的索引位置
     * @param rightPos 第二个交换的值的索引位置
     */
    private void swap(int leftPos, int rightPos) {
        int tmp;
        tmp = heap[leftPos];
        heap[leftPos] = heap[rightPos];
        heap[rightPos] = tmp;
    }

    /**
     * 最大堆化某个节点 递归函数
     * 此方法已经假设左子树和右子树已经堆化了 只需要处理根节点即可
     * 堆化一棵树的时间复杂度为logN
     *
     * @param pos
     */
    private void maxHeapify(int pos) {
        // 如果是叶子结点 则无需处理
        if (isLeaf(pos)) {
            return;
        }
        // 根节点需要小于左子节点和右子节点里的至少一个
        if (heap[pos] < heap[leftChild(pos)]
                || heap[pos] < heap[rightChild(pos)]) {
            // 如果左子节点 大于右子节点 则证明左子节点是最大的 交换根节点和左子节点 并确保交换后的左子节点是最大堆化
            if (heap[leftChild(pos)]
                    > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                // 否则 交换根节点和右子节点的值 并确保交换后的右子节点是最大堆化
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }


    /**
     * 向最大堆中插入一个元素
     * 时间复杂度：logN
     *
     * @param element
     */
    public void insert(int element) {
        // 直接添加在末尾
        heap[++size] = element;

        // 保证添加元素后的最大堆依然是最大堆
        int current = size;
        // 向上冒泡 只需要比较当前节点和父节点即可？ 因为原先父节点已经保证了是最大堆了
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }


    /**
     * 从最大堆中提取最大值
     * 时间复杂度：logN 因为在提取之后调用了一次maxHeapify方法 该方法时间复杂度为logN
     *
     * @return
     */
    public int extractMax() {
        // 最大值所在位置为1
        int popped = heap[1];
        // 将数组尾部的值提取到头部
        heap[1] = heap[size--];
        // 重新最大化堆
        maxHeapify(1);
        return popped;
    }


    /**
     * 对根为i的堆进行重建 前提：原树已经是一个堆
     * 若要直接构建一个堆 不能使用此方法
     *
     * @param array 数组
     * @param n     堆的大小（元素个数）
     * @param i     要最大堆化的数组索引位置
     * @return
     */
    public void heapify(int[] array, int n, int i) {
        if (array == null || array.length == 0) {
            return;
        }
        // 取三个位置里最大的那一个
        int largestIndex = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && array[left] > array[i]) {
            largestIndex = left;
        }

        if (right < n && array[right] > array[largestIndex]) {
            largestIndex = right;
        }

        // 最大的值不是i 需要交换
        if (largestIndex != i) {
            int temp = array[i];
            array[i] = array[largestIndex];
            array[largestIndex] = temp;
            // 继续堆化
            heapify(array, n, largestIndex);
        }
    }

    /**
     * 删除最大堆的根节点
     * 返回啥？
     * @param array 堆数组
     * @param n 堆的元素个数
     * @return
     */
    public int deleteRoot(int[] array, int n) {
        int lastNode = array[n - 1];
        array[0] = lastNode;
        // 重新构造堆
        heapify(array, n - 1, 0);
        return n - 1;
    }

    /**
     * 向堆中添加预算
     *
     * @param array 数组
     * @param n     数组大小
     * @param value 插入值
     */
    public void insert(int[] array, int n, int value) {
        array[n] = value;
        int current = n;
        int parent = parentFromZero(current);
        while (array[current] > array[parent]) {
            swap(current, parent);
            current = parent;
            parent = parentFromZero(current);
        }
    }

}
