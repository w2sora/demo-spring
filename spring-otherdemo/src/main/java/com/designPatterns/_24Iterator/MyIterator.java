package com.designPatterns._24Iterator;

public class MyIterator implements Iterator {
    private Collection collection;
    private int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if (pos > 0) {
            return collection.get(--pos);
        } else {
            return null;
        }
    }

    @Override
    public Object next() {
        if (pos < collection.size() - 1) {
            return collection.get(++pos);
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return pos < collection.size() - 1;
    }

    @Override
    public Object first() {
        pos = 0;
        return collection.get(pos);
    }
}
