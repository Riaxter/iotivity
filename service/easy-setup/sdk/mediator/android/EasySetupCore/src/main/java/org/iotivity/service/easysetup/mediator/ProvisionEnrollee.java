/**
 * ***************************************************************
 * <p>
 * Copyright 2015 Samsung Electronics All Rights Reserved.
 * <p>
 * <p>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * ****************************************************************
 */

package org.iotivity.service.easysetup.mediator;

import android.content.Context;
import android.util.Log;

public class ProvisionEnrollee {
    private static final String TAG = "ProvisionEnrollee";
    private Context appContext = null;
    private EasySetupManager easySetupManagerNativeInstance = null;
    private IProvisioningListener provisioningListener;

    /**
     * Constructor for ProvisionEnrollee. Constructs a new ProvisionEnrollee.
     */
    public ProvisionEnrollee(Context context) {
        appContext = context;
        easySetupManagerNativeInstance = EasySetupManager.getInstance();
        easySetupManagerNativeInstance.initEasySetup();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        easySetupManagerNativeInstance.terminateEasySetup();
    }

    public void provisionEnrollee(String ipAddress, String netSSID,
                                  String netPWD, int connectivityType) {
        easySetupManagerNativeInstance.provisionEnrollee(ipAddress, netSSID,
                netPWD, connectivityType);
    }

    public void stopEnrolleeProvisioning(int connectivityType) {
        easySetupManagerNativeInstance
                .stopEnrolleeProvisioning(connectivityType);
    }

    public void ProvisioningStatusCallBack(int statuscode) {
        Log.d(TAG,
                "onFinishProvisioning() inside Android Java application. statuscode - "
                        + statuscode);
        this.provisioningListener.onFinishProvisioning(statuscode);
    }

    public void registerProvisioningHandler(
            IProvisioningListener provisioningListener) {
        this.provisioningListener = provisioningListener;
        EasySetupCallbackHandler.getInstance()
                .registerProvisioningHandler(this);
    }
}
