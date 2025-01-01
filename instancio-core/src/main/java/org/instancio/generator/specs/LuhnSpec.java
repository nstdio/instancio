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
package org.instancio.generator.specs;

import org.instancio.generator.ValueSpec;

/**
 * A spec for generating numbers that pass the Luhn checksum algorithm.
 *
 * @since 3.1.0
 */
public interface LuhnSpec extends LuhnGeneratorSpec, ValueSpec<String> {

    @Override
    LuhnSpec length(int length);

    @Override
    LuhnSpec length(int min, int max);

    @Override
    LuhnSpec startIndex(int startIndex);

    @Override
    LuhnSpec endIndex(int endIndex);

    @Override
    LuhnSpec checkDigitIndex(int checkDigitIndex);

    @Override
    LuhnSpec nullable();
}
