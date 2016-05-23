//******************************************************************
//
// Copyright 2016 Samsung Electronics All Rights Reserved.
//
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
#include "NSProviderSystem.h"

static NSConnectionState NSProviderConnectionState;

void NSSetProviderConnectionState(NSConnectionState state)
{
    OIC_LOG(INFO, SUBSCRIPTION_TAG, "Change Connection State");
    NS_LOG(DEBUG, "NSSetProviderConnectionState");

    NSProviderConnectionState = state;
}

NSConnectionState NSGetProviderConnectionState()
{
    OIC_LOG(INFO, SUBSCRIPTION_TAG, "Change Connection State");
    //NS_LOG(DEBUG, "NSGetProviderConnectionState");

    return NSProviderConnectionState;
}
