package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Nested
    class Split {
        @Test
        void split1() {
            String[] actual = "1,2".split(",");
            assertThat(actual).containsExactly("1", "2");
        }

        @Test
        void split2() {
            String[] actual = "1,2".split(",");
            assertThat(actual).contains("1");
        }
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Nested
    class CharAt {
        @Test
        void charAt1() {
            char actual = "abc".charAt(1);
            assertThat(actual).isEqualTo('b');
        }

        @Test
        @DisplayName("인덱스 범위를 벗어나면 IndexOutOfBoundsException 반환")
        void charAt2() {
            assertThatThrownBy(() -> {
                char actual = "abc".charAt(3);
            }).isInstanceOf(IndexOutOfBoundsException.class);

            /*assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                        char actual = "abc".charAt(3);
                    });*/
        }
    }
}
