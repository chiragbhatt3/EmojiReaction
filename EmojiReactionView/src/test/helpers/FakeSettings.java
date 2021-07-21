/*
 * Copyright 2015 Stuart Kent
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package amplify.helpers;

import com.example.amplify.lib.tracking.interfaces.ISettings;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An in-memory implementation of ISettings.
 */

public class FakeSettings<T> implements ISettings<T> {

    private final Map<String, T> mostRecentValuesWritten = new ConcurrentHashMap<>();

    @Override
    public void writeTrackingValue(@NotNull final String trackingKey, final T value) {
        mostRecentValuesWritten.put(trackingKey, value);
    }

    @Nullable
    @Override
    public T readTrackingValue(@NotNull final String trackingKey) {
        return mostRecentValuesWritten.get(trackingKey);
    }

}
