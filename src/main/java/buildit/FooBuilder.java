package buildit;

import java.net.URI;

/**
 * Created by agavrilov on 24/11/14.
 */
public class FooBuilder {
    private int number;
    private String string;
    private URI uri;

    // Add special annotation that will be recognized by module
    private static class FooImpl extends Foo {
        private final int number;
        private final String string;
        private final URI uri;

        // @JsonCreator
        private FooImpl(final int number, final String string, final URI uri) {
            super(number, string, uri);
            this.number = number;
            this.string = string;
            this.uri = uri;
        }

        @Override
        public int number() {
            return number;
        }

        @Override
        public String string() {
            return string;
        }

        @Override
        public URI uri() {
            return uri;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Foo{");
            sb.append("number=").append(number);
            sb.append(", string='").append(string).append('\'');
            sb.append(", uri=").append(uri);
            sb.append('}');
            return sb.toString();
        }
    }

    public FooBuilder() {

    }

    public FooBuilder(final Foo from) {
        number = from.number();
        string = from.string();
        uri = from.uri();
    }

    public FooBuilder number(int number) {
        this.number = number;
        return this;
    }

    public FooBuilder string(String string) {
        this.string = string;
        return this;
    }

    public FooBuilder uri(URI uri) {
        this.uri = uri;
        return this;
    }

    public Foo build() {
        return new FooImpl(number, string, uri);
    }
}