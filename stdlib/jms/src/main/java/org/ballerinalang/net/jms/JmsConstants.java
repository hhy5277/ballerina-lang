/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.ballerinalang.net.jms;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;

/**
 * Constants for jms.
 *
 * @since 0.8.0
 */
public class JmsConstants {
    // Error fields
    public static final String JMS_ERROR_RECORD = "JMSError";
    public static final String JMS_ERROR_CODE = "{ballerina/jms}JMSError";

    // Common fields
    public static final String B_OBJECT_FIELD_PRODUCER_ACTIONS = "producerActions";
    public static final String B_OBJECT_FIELD_CONFIG = "config";

    // Method fields
    public static final String METHOD_FIELD_ACTIONS = "actions";
    public static final String METHOD_FIELD_DATA = "data";

    // Connection fields
    public static final String CONNECTION_CONFIG = "config";

    // Session fields
    public static final String SESSION_CONFIG = "config";

    // Queue Sender fields
    public static final String QUEUE_SENDER_FIELD_CONFIG = B_OBJECT_FIELD_CONFIG;
    public static final String QUEUE_SENDER_FIELD_QUEUE_NAME = "queueName";
    public static final String QUEUE_SENDER_FIELD_PRODUCER_ACTIONS = B_OBJECT_FIELD_PRODUCER_ACTIONS;

    // Topic publisher fields
    public static final String TOPIC_PUBLISHER_FIELD_CONFIG = B_OBJECT_FIELD_CONFIG;
    public static final String TOPIC_PUBLISHER_FIELD_TOPIC_PATTERN = "topicPattern";
    public static final String TOPIC_PUBLISHER_FIELD_PRODUCER_ACTIONS = B_OBJECT_FIELD_PRODUCER_ACTIONS;

    // Consumer fields
    public static final String CONSUMER_CONFIG = "config";
    public static final String QUEUE_NAME = "queueName";
    public static final String TOPIC_PATTERN = "topicPattern";
    public static final String CONSUMER_IDENTIFIER = "identifier";
    public static final String CONSUMER_ACTIONS = "consumerActions";

    // Destination fields
    public static final String DESTINATION_NAME = "destinationName";
    public static final String DESTINATION_TYPE = "destinationType";

    // Native objects
    public static final String JMS_CONNECTION = "jms_connection_object";
    public static final String JMS_SESSION = "jms_session_object";
    public static final String JMS_PRODUCER_OBJECT = "jms_producer_object";
    public static final String JMS_MESSAGE_OBJECT = "jms_message_object";
    public static final String JMS_CONSUMER_OBJECT = "jms_consumer_object";
    public static final String JMS_DESTINATION_OBJECT = "jms_destination_object";

    // Used to keep the session wrapper
    public static final String SESSION_CONNECTOR_OBJECT = "jms_session_connector_object";

    public static final String BALLERINA_PACKAGE_JMS = "ballerina/jms";
    public static final String CONFIG_FILE_PATH = "configFilePath";

    public static final String PROPERTIES_MAP = "properties";

    /**
     * Parameters from the user.
     */
    public static final String ALIAS_CONNECTION_FACTORY_NAME = "connectionFactoryName";

    /**
     * Type of the connection factory. Whether queue or topic connection factory.
     */
    public static final String ALIAS_DESTINATION_TYPE = "destinationType";
    /**
     * jms destination.
     */
    public static final String ALIAS_DESTINATION = "destination";
    /**
     * Connection property factoryInitial parameter name.
     */
    public static final String ALIAS_INITIAL_CONTEXT_FACTORY = "initialContextFactory";
    /**
     * Connection property providerUrl parameter name.
     */
    public static final String ALIAS_PROVIDER_URL = "providerUrl";
    public static final String ALIAS_USERNAME = "username";
    public static final String ALIAS_PASSWORD = "password";
    public static final String ALIAS_ACK_MODE = "acknowledgementMode";
    public static final String ALIAS_CLIENT_ID = "clientId";
    public static final String ALIAS_DURABLE_SUBSCRIBER_ID = "subscriptionId";
    /**
     * Alias for MB initial context factory name.
     */
    public static final String MB_ICF_ALIAS = "wso2mbInitialContextFactory";
    public static final String BMB_ICF_ALIAS = "bmbInitialContextFactory";

    public static final String MB_ICF_NAME = "org.wso2.andes.jndi.PropertiesFileInitialContextFactory";
    public static final String MB_CF_NAME_PREFIX = "connectionfactory.";

    private static Map<String, String> mappingParameters;

    public static final String PARAM_CONNECTION_FACTORY_JNDI_NAME = "transport.jms.ConnectionFactoryJNDIName";
    public static final String PARAM_CONNECTION_FACTORY_TYPE = "transport.jms.ConnectionFactoryType";
    public static final String PARAM_DESTINATION_NAME = "transport.jms.Destination";
    public static final String PARAM_ACK_MODE = "transport.jms.SessionAcknowledgement";
    public static final String PARAM_DURABLE_SUB_ID = "transport.jms.DurableSubscriberName";
    public static final String PARAM_CLIENT_ID = "transport.jms.DurableSubscriberClientId";

    static {
        mappingParameters = new HashMap<>();
        mappingParameters.put(ALIAS_INITIAL_CONTEXT_FACTORY, Context.INITIAL_CONTEXT_FACTORY);
        mappingParameters.put(ALIAS_CONNECTION_FACTORY_NAME, PARAM_CONNECTION_FACTORY_JNDI_NAME);
        mappingParameters.put(ALIAS_DESTINATION_TYPE, PARAM_CONNECTION_FACTORY_TYPE);
        mappingParameters.put(ALIAS_PROVIDER_URL, Context.PROVIDER_URL);
        mappingParameters.put(ALIAS_DESTINATION, PARAM_DESTINATION_NAME);
        mappingParameters.put(ALIAS_ACK_MODE, PARAM_ACK_MODE);
        mappingParameters.put(ALIAS_CLIENT_ID, PARAM_CLIENT_ID);
        mappingParameters.put(ALIAS_DURABLE_SUBSCRIBER_ID, PARAM_DURABLE_SUB_ID);
    }

    public static final Map<String, String> MAPPING_PARAMETERS = Collections.unmodifiableMap(mappingParameters);

    public static final String JMS_MESSAGE_STRUCT_NAME = "Message";

    public static final String JMS_DESTINATION_STRUCT_NAME = "Destination";

    /**
     * Acknowledge Modes.
     */
    public static final String AUTO_ACKNOWLEDGE_MODE = "AUTO_ACKNOWLEDGE";

    public static final String CLIENT_ACKNOWLEDGE_MODE = "CLIENT_ACKNOWLEDGE";
    public static final String DUPS_OK_ACKNOWLEDGE_MODE = "DUPS_OK_ACKNOWLEDGE";
    public static final String SESSION_TRANSACTED_MODE = "SESSION_TRANSACTED";

    private JmsConstants() {
    }
}
