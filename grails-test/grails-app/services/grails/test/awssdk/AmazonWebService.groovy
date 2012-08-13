package grails.test.awssdk

import com.amazonaws.AmazonWebServiceClient
import com.amazonaws.ClientConfiguration
import com.amazonaws.Protocol
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowAsyncClient
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient

class AmazonWebService {

	String defaultRegion = 'us-east-1'

	def grailsApplication

	private Map asyncClients = [:]
	private Map clients = [:]

	AmazonSimpleWorkflowAsyncClient getSwfAsync(String region = '') {
		getServiceClient('swf', region, true) as AmazonSimpleWorkflowAsyncClient
	}

	AmazonSimpleWorkflowClient getSwf(String region = '') {
		getServiceClient('swf', region) as AmazonSimpleWorkflowClient
	}

	// PRIVATE

	private def getAwsConfig() {
//		grailsApplication.config.awssdk
		def mockedConfig = [:]
		mockedConfig.accessKey = "{ACCESS_KEY}"
		mockedConfig.secretKey = "{SECRET_KEY}"
		mockedConfig
	}

	private BasicAWSCredentials buildCredentials(defaultConfig, serviceConfig) {
		Map config = [accessKey: defaultConfig.accessKey ?: '',
					secretKey: defaultConfig.secretKey ?: '']
		if (serviceConfig) {
			if (serviceConfig.accessKey) {
				config.accessKey = serviceConfig.accessKey
			}
			if (serviceConfig.secretKey) {
				config.secretKey = serviceConfig.secretKey
			}
		}
		new BasicAWSCredentials(config.accessKey, config.secretKey)
	}

	private ClientConfiguration buildClientConfiguration(defaultConfig, serviceConfig) {
		Map config = [connectionTimeout: defaultConfig.connectionTimeout ?: 0,
					maxConnections: defaultConfig.maxConnections ?: 0,
					maxErrorRetry: defaultConfig.maxErrorRetry ?: 0,
					protocol : defaultConfig.protocol ?: '',
					socketTimeout: defaultConfig.socketTimeout ?: 0,
					userAgent: defaultConfig.userAgent ?: '']
		if (serviceConfig) {
			if (serviceConfig.connectionTimeout) config.connectionTimeout = serviceConfig.connectionTimeout
			if (serviceConfig.maxConnections) config.maxConnections = serviceConfig.maxConnections
			if (serviceConfig.maxErrorRetry) config.maxErrorRetry = serviceConfig.maxErrorRetry
			if (serviceConfig.protocol) config.protocol = serviceConfig.protocol
			if (serviceConfig.socketTimeout) config.socketTimeout = serviceConfig.socketTimeout
			if (serviceConfig.userAgent) config.connectionTimeout = serviceConfig.userAgent
		}

		ClientConfiguration clientConfiguration = new ClientConfiguration()
		if (config.connectionTimeout) clientConfiguration.connectionTimeout = config.connectionTimeout
		if (config.maxConnections) clientConfiguration.maxConnections = config.maxConnections
		if (config.maxErrorRetry) clientConfiguration.maxErrorRetry = config.maxErrorRetry
		if (config.protocol) {
			if (config.protocol.toUpperCase() == 'HTTP') {
				clientConfiguration.protocol = Protocol.HTTP
			} else {
				clientConfiguration.protocol = Protocol.HTTPS
			}
		}
		if (config.socketTimeout) clientConfiguration.socketTimeout = config.socketTimeout
		if (config.userAgent) clientConfiguration.userAgent = config.userAgent
		clientConfiguration
	}

	private AmazonWebServiceClient getServiceClient(String service, String region = '', Boolean async = false) {
		if (!region) {
			if (awsConfig[service]?.region) {
				region = awsConfig[service].region
			} else if (awsConfig?.region) {
				region = awsConfig.region
			} else {
				region = defaultRegion
			}
		}

		if (async && !asyncClients[service]) {
			asyncClients[service] = [:]
		} else if (!async && !clients[service]) {
			clients[service] = [:]
		}

		AmazonWebServiceClient client
		if ((async && !asyncClients[service].hasProperty(region)) || (!async && !clients[service].hasProperty(region))) {
			BasicAWSCredentials credentials = buildCredentials(awsConfig, awsConfig[service])

			if (async) {
				if (credentials.AWSAccessKeyId && credentials.AWSSecretKey) {
					client = new AmazonSimpleWorkflowAsyncClient(credentials)
				} else {
					client = new AmazonSimpleWorkflowAsyncClient()
				}
				asyncClients[service][region] = client
			} else {
				if (credentials.AWSAccessKeyId && credentials.AWSSecretKey) {
					client = new AmazonSimpleWorkflowClient(credentials)
				} else {
					client = new AmazonSimpleWorkflowClient()
				}
				clients[service][region] = client
			}
			client.endpoint = "swf.${region}.amazonaws.com"
			client.configuration = buildClientConfiguration(awsConfig, awsConfig[service])
		} else {
			client = async ? asyncClients[service][region] : clients[service][region]
		}
		
		client
	}

}
