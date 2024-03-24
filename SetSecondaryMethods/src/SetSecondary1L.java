import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods {@code add} and {@code remove}
 * for {@code Set}.
 *
 * @param <T>
 *            type of {@code Set} elements
 */
public final class SetSecondary1L<T> extends Set1L<T> {

    /**
     * No-argument constructor.
     */
    public SetSecondary1L() {
        super();
    }

    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        // TODO - fill in body
        Set<T> thisResult = new Set1L<>();
        Set<T> sResult = new Set1L<>();
        for (T i : s) {
            for (T j : this) {
                if (i == j) {
                    thisResult.add(j);
                } else {
                    sResult.add(j);
                }
            }
        }
        this.transferFrom(thisResult);
        s.transferFrom(sResult);
        return this;

    }

    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        // TODO - fill in body

    }

}