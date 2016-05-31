/*
 * (C) Copyright 2016 Kurento (http://kurento.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.kurento.client;

import java.util.concurrent.Executor;

public interface KurentoObject {

  boolean isCommited();

  void waitCommited() throws InterruptedException;

  void whenCommited(Continuation<?> continuation);

  void whenCommited(Continuation<?> continuation, Executor executor);

  /**
   * Explicitly release a media object form memory. All of its children will also be released.
   *
   **/
  void release();

  /**
   * Explicitly release a media object form memory. All of its children will also be released.
   * Asynchronous call.
   *
   * @param continuation
   *          {@link #onSuccess(void)} will be called when the actions complete. {@link #onError}
   *          will be called if there is an exception.
   *
   **/
  void release(Continuation<Void> continuation);

  void release(Transaction tx);

  String getId();

}
