package net.zffu.intmap;


import java.io.Serializable;
import java.util.*;

/**
 * <p>An {@link java.util.Map} that is using Integers as keys.</p>
 * @param <V> the type of values.
 */
public class IntMap<V> extends AbstractMap<Integer, V> implements Serializable, Cloneable {

    /**
     * Shared empty values array instance for empty maps.
     */
    private static final Object[] DEFAULT_MAP = {};

    private static final int DEFAULT_MAP_CAPACITY = 10;
    /**
     * The Map's values array.
     */
    private Object[] values;

    /**
     * The Cached Map's Size.
     */
    private int size;

    /**
     * Constructs an {@link IntMap} with a predefined capacity.
     * @param capacity the capacity (max key index).
     */
    public IntMap(int capacity) {
        if(capacity > 0) {
            this.values = new Object[capacity];
        }
        else {
            this.values = DEFAULT_MAP;
        }
    }

    /**
     * Constructs an {@link IntMap} with the default capacity.
     */
    public IntMap() {
        this.values = new Object[DEFAULT_MAP_CAPACITY];
    }



    /**
     * Returns the element located at the specified key index.
     * @param key the key.
     * @throws IndexOutOfBoundsException if the key is negative or exceeds the map's capacity.
     * @return the element.
     */
    public V get(int key) {
        Objects.checkIndex(key, this.values.length);
        return (V) this.values[key];
    }

    /**
     * Sets the element of the specified key to the specified value.
     * @param key the key.
     * @param value the new value.
     * @throws IndexOutOfBoundsException if the key is negative or exceeds the map's capacity.
     */
    @Override
    public V put(Integer key, V value) {
        Objects.checkIndex(key, this.values.length);
        V old = (V) this.values[key];
        this.values[key] = value;
        this.size++;
        return old;
    }

    /**
     * Removes the element of the specified key.
     * @param key the key.
     *
     */
    @Override
    public V remove(Object key) {
        if(!containsKey(key)) return null;
        V old = (V) this.values[(Integer)key];
        this.values[(Integer)key] = null;
        this.size--;
        return old;
    }

    /**
     * Determines if the provided key has an element in the {@link IntMap}.
     * @param key the key as an Integer.
     * @return true if the key stores an element, otherwise false.
     */
    @Override
    public boolean containsKey(Object key) {
        int keyInt = (Integer) key;
        if(!checkKey(keyInt)) return false;
        return (this.values[keyInt] != null);
    }

    /**
     * Determines if the key could be contained in the {@link IntMap}.
     * @param key the key as an Integer.
     * @return true if the key could be contained, otherwise false.
     */
    private boolean checkKey(int key) {
        return (key >= 0 && key <= this.values.length);
    }

    /**
     * Gets the size of the {@link IntMap}
     * @return the size of the {@link IntMap}.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Increases the capacity of the {@link IntMap}
     * @param minCapacity the minimum capacity the {@link IntMap} must have.
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = this.values.length;
        if(minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if(newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            this.values = Arrays.copyOf(this.values, newCapacity);
        }
    }

    @Override
    public Set<Entry<Integer, V>> entrySet() {
        return null;
    }


}
