# genericNotifications
Generric Notification Application

Instruction to run the application

1. Clone repository in your local system.
2. To build project run mvn clean install and run the Jar.
3. Update from email and password in application.properties file.
4. Update Recepeint mail in updateStateAndNotifyUser() function.
5. Go to http://localhost:8080/update-status(PUT) to send email notification

Alternative: Use the following JSON to execute request in postman.

1. Copy the JSON and import it to Postman.
2. Run the application and execute the request.

{
	"id": "5871155d-373e-0065-b494-86cdae49b7c2",
	"name": "Generic Notifications",
	"description": "",
	"order": [
		"197668fa-6e81-0e67-c75a-3e90b1e012fa",
		"d0c0f19f-9fa5-2b67-49e0-e47f9a687eda"
	],
	"folders": [],
	"folders_order": [],
	"timestamp": 1621743502837,
	"owner": 0,
	"public": false,
	"requests": [
		{
			"id": "197668fa-6e81-0e67-c75a-3e90b1e012fa",
			"headers": "",
			"headerData": [],
			"url": "http://localhost:8080/notify-user",
			"queryParams": [],
			"preRequestScript": null,
			"pathVariables": {},
			"pathVariableData": [],
			"method": "PUT",
			"data": null,
			"dataMode": "params",
			"version": 2,
			"tests": null,
			"currentHelper": "normal",
			"helperAttributes": {},
			"time": 1621743577956,
			"name": "Predefined Notification",
			"description": "API sends predfined email notificaton to user",
			"collectionId": "5871155d-373e-0065-b494-86cdae49b7c2",
			"responses": []
		},
		{
			"id": "d0c0f19f-9fa5-2b67-49e0-e47f9a687eda",
			"headers": "Content-Type: application/json\n",
			"headerData": [
				{
					"key": "Content-Type",
					"value": "application/json",
					"description": "",
					"enabled": true
				}
			],
			"url": "http://localhost:8080/notify-user",
			"queryParams": [],
			"pathVariables": {},
			"pathVariableData": [],
			"preRequestScript": null,
			"method": "PUT",
			"collectionId": "5871155d-373e-0065-b494-86cdae49b7c2",
			"data": [],
			"dataMode": "raw",
			"name": "Custom Notification",
			"description": "API sends custom email notification to user",
			"descriptionFormat": "html",
			"time": 1621743668891,
			"version": 2,
			"responses": [],
			"tests": null,
			"currentHelper": "normal",
			"helperAttributes": {},
			"rawModeData": "{\n\t\"toEmail\" : \"notification@sharklasers.com\",\n\t\"subject\" : \"custom subject\",\n\t\"body\" : \"custom body\"\n}"
		}
	]
}
