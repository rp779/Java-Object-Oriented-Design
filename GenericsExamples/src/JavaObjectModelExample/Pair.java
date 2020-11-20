/**
 * @author Ross Parsons
 * */
package JavaObjectModelExample;

import java.io.Serializable;
import java.util.Objects;

public class Pair<K,V> implements Serializable, Cloneable {

    private K k;
    private V v;

    public Pair(K k, V v)
    {
        this.k = k;
        this.v = v;
    }

    public K k(){return this.k;}

    public V v(){return this.v;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(k, pair.k) &&
                Objects.equals(v, pair.v);
    }

    @Override
    public int hashCode() {
        int result = 17; // some prime number
        result = 31 * result + k().hashCode();
        result = 31 * result + v().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "k=" + k +
                ", v=" + v +
                '}';
    }

    @Override
    protected Pair clone() throws CloneNotSupportedException {
        try {
            Pair cloned = (Pair) super.clone();
            cloned.k = this.k;
            cloned.v = this.v;
            return cloned;
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
