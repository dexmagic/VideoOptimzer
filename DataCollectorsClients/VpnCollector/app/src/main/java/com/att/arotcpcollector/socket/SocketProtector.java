/*
 *  Copyright 2014 AT&T
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.att.arotcpcollector.socket;

import java.net.DatagramSocket;
import java.net.Socket;

/**
 * Singleton class that is created in child class of VpnService which implements
 * IProtectSocket, then this class is used everywhere else that needs to protect
 * socket from going through VPN interface.
 * 
 * @author Borey Sao Date: June 1, 2014
 */
public class SocketProtector {
	private static Object synObject = new Object();
	private static volatile SocketProtector instance = null;
	private IProtectSocket protector = null;

	private SocketProtector() {

	}

	public static SocketProtector getInstance() {
		if (instance == null) {
			synchronized (synObject) {
				if (instance == null) {
					instance = new SocketProtector();
				}
			}
		}
		return instance;
	}

	/**
	 * set class that implements IProtectSocket to be used only if it was never set
	 * before.
	 * 
	 * @param protector
	 */
	public void setProtector(IProtectSocket protector) {
		if (this.protector == null) {
			this.protector = protector;
		}
	}

	public void protect(Socket socket) {
		protector.protectSocket(socket);
	}

	public void protect(int socket) {
		protector.protectSocket(socket);
	}

	public void protect(DatagramSocket socket) {
		protector.protectSocket(socket);
	}
}
