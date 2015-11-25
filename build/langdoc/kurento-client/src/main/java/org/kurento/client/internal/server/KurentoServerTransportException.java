/*
 * (C) Copyright 2014 Kurento (http://kurento.org/)
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
package org.kurento.client.internal.server;

import org.kurento.commons.exception.KurentoException;


/**
 * This exception occurs when there is a communication error. This could happen
 * either when trying to reach KMS, or when the server is trying to send a
 * response to the client.
 * 
 * @author Ivan Gracia (izanmail@gmail.com)
 * @since 4.2.1
 * 
 */
public class KurentoServerTransportException extends KurentoException {

	private static final long serialVersionUID = -9166377169939591329L;

	public KurentoServerTransportException(String message, Throwable cause) {
		super(message, cause);
	}

	public KurentoServerTransportException(String message) {
		super(message);
	}

	public KurentoServerTransportException(Throwable cause) {
		super(cause);
	}

}
