/*
 * Copyright 2022-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.instancio.internal.assignment;

import org.instancio.Select;
import org.instancio.exception.InstancioApiException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InternalAssignmentTest {

    @Nested
    class ToStringTest {

        @Test
        void verifyEmptyToString() {
            assertThat(InternalAssignment.builder().build())
                    .hasToString("InternalAssignment[origin=null, destination=null]");
        }

        @Test
        void verifyToString() {
            assertThat(InternalAssignment.builder()
                    .origin(Select.field("foo"))
                    .destination(Select.field("bar"))
                    .build())
                    .hasToString("InternalAssignment[origin=field(\"foo\"), destination=field(\"bar\")]");
        }
    }

    @Nested
    class ValidationTest {
        private final InternalAssignment.Builder builder = InternalAssignment.builder();

        @Test
        void origin() {
            assertThatThrownBy(() -> builder.origin(null))
                    .isExactlyInstanceOf(InstancioApiException.class)
                    .hasMessageContaining("origin selector must not be null");
        }

        @Test
        void destination() {
            assertThatThrownBy(() -> builder.destination(null))
                    .isExactlyInstanceOf(InstancioApiException.class)
                    .hasMessageContaining("destination selector must not be null");
        }
    }
}
