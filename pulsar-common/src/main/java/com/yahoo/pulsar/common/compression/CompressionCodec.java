/**
 * Copyright 2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.pulsar.common.compression;

import java.io.IOException;

import io.netty.buffer.ByteBuf;

/**
 * Generic compression codec interface
 */
public interface CompressionCodec {

    /**
     * Compress a buffer
     *
     * @param raw
     *            a buffer with the uncompressed content. The reader/writer indexes will not be modified
     * @return a new buffer with the compressed content. The buffer needs to be released by the receiver
     */
    ByteBuf encode(ByteBuf raw);

    /**
     * Decompress a buffer.
     *
     * The buffer needs to have been compressed with the matching Encoder.
     *
     * @param encoded
     *            the compressed content
     * @param uncompressedSize
     *            the size of the original content
     * @return a ByteBuf with the compressed content. The buffer needs to be released by the receiver
     * @throws IOException
     *             if the decompression fails
     */
    ByteBuf decode(ByteBuf encoded, int uncompressedSize) throws IOException;

}
