package io.rdk.leetlab.core.Queue.p622_design_circular_queue;

class MyCircularQueue1 {
    //设计属性,才是设计数据结构的关键所在.很重要
    //如果某个属性,经常会被使用,那么我们可以考虑留下.否则应该降低冗余度.
    /** 每个属性的设计及其含义:
     queue: 一个固定大小的数组，用于保存循环队列的元素。
     headIndex: 就是一个整数,用于表示头的索引
     current_element_size: 表示当前队列中已含有的元素数量.
     q_capacity:表示此循环队列的容量.队列中最多可以容纳的元素数量.
     */

    private int[] queue;
    private int headIndex;
    private int current_element_size;
    private int q_capacity;

    //初始化数据结构,并且设置循环数组的容量为k.
    public MyCircularQueue1(int k) {
        this.q_capacity = k;
        this.queue = new int[k];//容量为k,那么我们用来实现的数组容量应该也为k.
        this.current_element_size = 0; // 一开始循环数组里面只有0个元素.
        this.headIndex = 0;//一开始循环数组的头,在index为0的位置.
    }

    //插入一个元素的操作.enQueue.
    //如果插入一个元素,那么元素应该在头索引的位置.
    //插入以后,尾巴应该会向后挪一位.
    //如果插入成功了,那么返回一个true.
    public boolean enQueue(int value) {
        if (this.current_element_size == this.q_capacity)//如果当前元素大小已经达到了循环队列的极限值,也就是 容量.
            //那么应该返回false.
            return false;
        //否则插入.并返回true.
        //this.queue[] = value. // 找到当前下标是关键.
        //题解给出的公式是: 尾部索引: (this.headIndex + this.count) % this.capacity
        //因此我们把这个公式填进去.
        this.queue[(this.headIndex + this.current_element_size) % this.q_capacity] = value;
        //由于headIndex会偏移，因此这个尾部的索引位置会是: (this.headIndex + this.count) % this.capacity
        this.current_element_size += 1;//成功插入以后,当然 当前元素的大小 会+1;
        return true;//插入成功了,我们返回一个true.
    }

    //删除头部索引指着的元素.deQueue
    //如果删除了头部索引的位置,该位置会空出空间.
    //并且头索引应该++.
    //如果当前队列中的元素数量(大小)为0,那么肯定就没有元素可以被删除了.
    //那么应该返回false
    //否则删除,并返回true
    public boolean deQueue() {
        if (this.current_element_size == 0) return false;

        //头节点位置.移动.
        //同样,这个数学公式是为什么我也不知道.稍后可能会模拟一下.
        this.headIndex = (this.headIndex + 1) % this.q_capacity;
        //当前队列中的元素数量(大小)应该减一.因为已经有一个元素被剔除.
        this.current_element_size -= 1;
        //返回true.
        return true;
    }

    //获得头索引上位置的元素.这个相对简单.
    public int Front() {
        //根据题意,如果当前的元素大小为0了,那么说明木有元素了.
        //返回一个-1作为标记.
        if (this.current_element_size == 0)
            return -1;

        //否则,就正常的取出头索引的值便可.
        return this.queue[this.headIndex];
    }

    //同理也是,上面我们已经求出来尾部位置的索引.我们把它取出来.
    public int Rear() {
        //边界条件判断.//如果队列中已无元素,则无法取出,返回-1
        if (this.current_element_size == 0)  return -1;

        //这里的关键其实还是求出尾部索引,所以根据数学公式:
        //尾部索引= (this.headIndex + this.count - 1) % this.capacity;
        int tailIndex = (this.headIndex + this.current_element_size - 1) % this.q_capacity;
        //直接取出.
        return this.queue[tailIndex];
    }

    //这个就更简单了.是否空.根据我们设计的属性,就能够得到结果.
    //当前队列元素大小若是为0.那么这个队列就是空.
    public boolean isEmpty() {
        return (this.current_element_size == 0);
    }

    //根据数学计算:如果当前队列元素值 已经达到 == 队列的容量.
    //则满.
    public boolean isFull() {
        return (this.current_element_size == this.q_capacity);
    }
}

