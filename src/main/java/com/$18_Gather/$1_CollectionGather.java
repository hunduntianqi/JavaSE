package com.$18_Gather;
/*
    Collection单列集合接口:
        单列集合: 元素以单个形式存在
        Collection ==> 单列集合祖宗接口, 全部单列集合均可以继承使用Collection的功能
        常用方法:
            public boolean add(E e): 向集合中添加对象
            public void clear(): 清空集合中所有元素
            public boolean remove(E e): 删除集合中指定的元素
            public boolean contains(Object obj): 判断集合中是否包含指定对象
            public boolean isEmpty(): 判断集合是否为空
            public int size(): 返回集合中元素的个数
        Collection系列集合通用遍历方式:
            1. 迭代器遍历:
                迭代器遍历不依赖索引, 是集合专用的遍历方式
                Iterator ==> java的迭代器类
                获取迭代器:
                    Iterator<E> iterator(): 返回迭代器对象, 默认指向当前集合的0索引
                Iterator常用方法:
                    a. boolean hasNext(): 判断当前索引位置是否有元素, 有则返回true, 没有则返回false
                    b. E next(): 获取当前索引的元素, 并将迭代器对象移向下一个索引
                    c. remove(): 从迭代器指向的Collection集合中删除迭代器返回的最后一个元素
                细节注意点:
                    1. 获取所有元素后, 指针不会复位, 再获取元素会产生 NoSuchElementException
                    2. while循环中只能使用一次next()方法, 因为判断条件为 hasNext()方法, 连续使用next()方法,
                       指针会向后移动多次, 如果最后一次循环次数不足, 会导致异常 NoSuchElementException
                    3. 迭代器遍历时, 不能使用集合的方法进行增加或删除, 会产生并发修改异常
            2. 增强for遍历:
                底层就是迭代器, 是为了简化迭代器代码的书写, 只有Collection单列集合与数组可以使用增强for进行遍历
                格式:
                    for (数据类型 变量名: 数组或集合名) {
                        循环体;
                    }
                细节: 对增强for中的变量名进行赋值, 不会修改集合中的数据, 该变量仅仅是一个第三方变量, 用来记录集合
                      中数据的值, 修改变量值对集合没有影响
            3. lambda表达式遍历:
                default void forEach(Consumer<? super T> action): 结合lambda遍历集合
                实际实现方式为使用匿名内部类方式重写方法, 再使用lambda表达式的方式进行代码简化
        List集合接口:
            List系列集合特点: 集合内元素有序, 可重复, 有索引
                a. 有序: 指存取元素顺序一致
                b. 有索引: 可以通过索引操作元素
                c. 可重复: 存储的元素可以重复
            List系列集合特有方法:
                void add(int index, E element): 在集合指定位置插入元素
                E remove(int index): 删除指定索引处的元素, 并返回被删除的元素
                E set(int index, E element): 修改指定索引处的元素, 并返回被修改的元素
                E get(int index): 获取指定索引处的元素
            List系列集合遍历方式:
                1. 迭代器遍历
                2. 列表迭代器遍历:
                    ListIterator: 属于迭代器Iterator的子接口:
                    获取列表迭代器:
                        ListIterator<E> listIterator(): 返回列表迭代器对象, 默认指针指向 0 索引
                    常用方法:
                        void add(E e): 将指定元素添加进集合
                        boolean hasNext(): 判断当前索引位置是否有元素, 有则返回true, 没有则返回false
                        E next(): 获取当前索引的元素, 并将迭代器对象移向下一个索引
                        void remove(): 从集合中删除由 next 或 previous 返回的最后一个元素
                        void set(E e): 以指定元素修改由 next 或 previous 返回的最后一个元素
                3. 增强for遍历
                4. lambda表达式遍历
                5. 普通for循环遍历
        List集合实现类:
            ArrayList集合:
                底层原理: ArrayList集合底层是数组结构
                a. 利用空参创建的集合, 在底层创建一个默认长度为 0 的数组
                b. 添加第一个元素时, 底层会创建一个新的长度为 10 的数组
                c. 数组元素存满后, 会按照原来的 1.5倍 扩容
                d. 如果一次添加元素在扩容 1.5倍 后还放不下, 则新创建数组的长度以实际添加元素后的长度为准
            LinkedList集合:
                底层原理: 双向链表, 查询慢, 增删快, 操作首尾元素时查询也快
                LinkedList集合操作首尾元素的独有方法:
                    public void addFirst(E e): 在该列表开头插入指定元素
                    public void addLast(E e): 将指定的元素追加到此列表的末尾
                    public E getFirst(): 返回列表中的第一个元素
                    public E getLast(): 返回列表中的最后一个元素
                    public E removeFirst(): 从此列表中删除并返回第一个元素
                    public E removeLast(): 从此列表中删除并返回最后一个元素
        Set集合接口:
            Set系列集合特点: 集合内元素无序, 不可重复, 无索引
            无序: 存取顺序不一致
            不可重复: 存储的元素不可以重复
            无索引: 无法通过索引操作元素, 不能使用普通for循环遍历
            遍历方式:
                1. 迭代器遍历
                2. 增强for遍历
                3. lambda表达式遍历
            哈希值: 是根据hashCode方法计算出来的int类型的整数, 方法定义在Object类中, 默认使用地址值进行计算
                    一般情况下, 会重写hashCode方法, 利用对象内部的属性值计算哈希值
                    对象的哈希值特点:
                        1. 如果没有重写hashCode方法, 不同对象计算出的哈希值是不同的
                        2. 如果已经重写hashCode方法, 只要属性值相同, 计算出的哈希值就是一样的
                        3. 在小概率情况下, 不同的属性值或地址值计算出来的哈希值也有可能一样(哈希碰撞)
        Set集合实现类:
            HashSet集合: 无序, 不重复, 无索引
                集合底层采取哈希表存储数据, 哈希表是一种对于增删改查数据性能都较好的结构
                哈希表组成:
                    JDK8以前: 数组 + 链表
                    JDK8之后: 数组 + 链表 + 红黑树
                去重机制: hashCode()方法和equals()方法
            LinkedHashSet集合: 有序, 不重复, 无索引, 是HashSet集合的子类
                集合底层结构依然是哈希表, 只是除此之外每个元素又额外增加了双链表的机制记录存储顺序
            TreeSet集合: 可排序, 不重复, 无索引
                集合底层基于红黑树实现的
                注意:TreeSet集合是一定要排序的, 可以将元素按照指定的规则进行排序
                默认规则:
                    1. 对于数值类型: Integer, Double等, 官方默认按照大小进行升序排序
                    2. 对于字符和字符串类型: 默认按照ASCII码表中的数字进行升序排序
                    3. 对于自定义类型如Student对象, TreeSet集合无法直接排序, 需要制定排序规则
                        3.1. 让自定义的类实现Comparable接口重写里面的compareTo方法来定制比较规则
                        3.2. TreeSet集合有参构造器, 可以设置Comparator接口对应的比较器对象, 来定制比较规则
                        当两种比较规则均存在时, 默认使用集合有参构造器自定义比较规则
                    4. 排序规则方法返回值特点:
                        负数: 表示当前要添加的元素是小的, 存左边
                        正数: 表示当前要添加的元素是大的, 存右边
                        0: 表示当前要添加的元素已经存在, 舍弃
    Collection集合使用场景:
        1. 如果想要集合中的元素可重复 ==> ArrayList集合, 基于数组实现, 是使用最多的集合
        2. 集合中元素可重复, 且增删操作明显多于查询操作 ==> LinkedList集合, 基于链表实现
        3. 如果想对集合中的元素去重 ==> HashSet集合, 基于哈希表实现, 是元素去重集合中使用最多的
        4. 如果想对集合中的元素去重, 并保证存取顺序 ==> LinkedHashSet集合, 基于哈希表和双链表实现,
           效率低于HashSet集合
        5. 如果想对集合中的元素进行排序 ==> TreeSet集合, 基于红黑树实现
*/

public class $1_CollectionGather {
}
