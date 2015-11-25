/*
 * (C) Copyright 2015 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */

package org.kurento.room.api.pojo;

public class UserParticipant {
	private String participantId;
	private String userName;
	private boolean streaming = false;

	public UserParticipant(String participantId, String userName,
			boolean streaming) {
		super();
		this.participantId = participantId;
		this.userName = userName;
		this.streaming = streaming;
	}

	public UserParticipant(String participantId, String userName) {
		super();
		this.participantId = participantId;
		this.userName = userName;
	}

	public String getParticipantId() {
		return participantId;
	}

	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isStreaming() {
		return streaming;
	}

	public void setStreaming(boolean streaming) {
		this.streaming = streaming;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((participantId == null) ? 0 : participantId.hashCode());
		result = prime * result + (streaming ? 1231 : 1237);
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserParticipant))
			return false;
		UserParticipant other = (UserParticipant) obj;
		if (participantId == null) {
			if (other.participantId != null)
				return false;
		} else if (!participantId.equals(other.participantId))
			return false;
		if (streaming != other.streaming)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		if (participantId != null)
			builder.append("participantId=").append(participantId).append(", ");
		if (userName != null)
			builder.append("userName=").append(userName).append(", ");
		builder.append("streaming=").append(streaming).append("]");
		return builder.toString();
	}
}
