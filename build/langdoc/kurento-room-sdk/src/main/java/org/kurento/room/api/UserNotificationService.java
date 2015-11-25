/*
 * (C) Copyright 2015 Kurento (http://kurento.org/)
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Lesser General Public License (LGPL)
 * version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.kurento.room.api;

import org.kurento.room.api.pojo.ParticipantRequest;
import org.kurento.room.exception.RoomException;
import org.kurento.room.internal.DefaultRoomEventHandler;

/**
 * This specification was designed so that the room manager could send
 * notifications or responses back to the remote peers whilst remaining isolated
 * from the transport or communications layers. The notification API will be
 * used by the default implementation of {@link RoomEventHandler} (provided by
 * the room SDK - {@link DefaultRoomEventHandler}). JSON-RPC messages
 * specification was used to define the following primitives.It is expected but
 * not required for the client-server communications to use this protocol. It is
 * left for the integrator to provide an implementation for this API. If the
 * developer chooses another mechanism to communicate with the client, they will
 * have to use their own implementation of RoomEventHandler which will completly
 * decouple the communication details from the room API.
 * 
 * @author <a href="mailto:rvlad@naevatec.com">Radu Tom Vlad</a>
 */
public interface UserNotificationService {

	/**
	 * Responds back to the remote peer with the result of the invoked method.
	 * 
	 * @param participantRequest instance of {@link ParticipantRequest} POJO
	 * @param result Object containing information that depends on the invoked
	 *        method. It’d normally be a JSON element-type object.
	 */
	void sendResponse(ParticipantRequest participantRequest, Object result);

	/**
	 * Responds back to the remote peer with the details of why the invoked
	 * method failed to be processed correctly.
	 * 
	 * @param participantRequest instance of {@link ParticipantRequest} POJO
	 * @param data optional (nullable) Object containing additional information
	 *        on the error. Can be a String or a JSON element-type object.
	 * @param error instance of {@link RoomException} POJO, includes a code and
	 *        error message
	 */
	void sendErrorResponse(ParticipantRequest participantRequest, Object data,
			RoomException error);

	/**
	 * Sends a notification to a remote peer. This falls outside the normal
	 * exchange of messages (client requests - server answers) so there’s no
	 * need for a request identifier.
	 * 
	 * @param participantId identifier of the targeted participant
	 * @param method String with the name of the method or event to be invoked
	 *        on the client
	 * @param params Object containing information that depends on the invoked
	 *        method. It’d normally be a JSON element-type object.
	 */
	void sendNotification(String participantId, String method, Object params);

	/**
	 * Notifies that any information associated with the provided request should
	 * be cleaned up (the participant has left).
	 * 
	 * @param participantRequest instance of {@link ParticipantRequest} POJO
	 */
	void closeSession(ParticipantRequest participantRequest);
}
