// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package amazons3connector.actions;

import java.io.InputStream;
import amazons3connector.AmazonHelper;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class JAV_GetObject_FileContent extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __AwsConfigParameter1;
	private amazons3connector.proxies.AwsConfig AwsConfigParameter1;
	private IMendixObject __S3BucketParameter1;
	private amazons3connector.proxies.S3Bucket S3BucketParameter1;
	private IMendixObject __S3Object;
	private amazons3connector.proxies.S3SummaryObject S3Object;
	private IMendixObject __OutputS3FileDocument;
	private amazons3connector.proxies.S3FileDocument OutputS3FileDocument;

	public JAV_GetObject_FileContent(IContext context, IMendixObject AwsConfigParameter1, IMendixObject S3BucketParameter1, IMendixObject S3Object, IMendixObject OutputS3FileDocument)
	{
		super(context);
		this.__AwsConfigParameter1 = AwsConfigParameter1;
		this.__S3BucketParameter1 = S3BucketParameter1;
		this.__S3Object = S3Object;
		this.__OutputS3FileDocument = OutputS3FileDocument;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.AwsConfigParameter1 = __AwsConfigParameter1 == null ? null : amazons3connector.proxies.AwsConfig.initialize(getContext(), __AwsConfigParameter1);

		this.S3BucketParameter1 = __S3BucketParameter1 == null ? null : amazons3connector.proxies.S3Bucket.initialize(getContext(), __S3BucketParameter1);

		this.S3Object = __S3Object == null ? null : amazons3connector.proxies.S3SummaryObject.initialize(getContext(), __S3Object);

		this.OutputS3FileDocument = __OutputS3FileDocument == null ? null : amazons3connector.proxies.S3FileDocument.initialize(getContext(), __OutputS3FileDocument);

		// BEGIN USER CODE
		AmazonS3 s3client = AmazonHelper.GetS3Client(AwsConfigParameter1);
		
		S3Object object = null;
		try
		{
			object = s3client.getObject(
					new GetObjectRequest(S3BucketParameter1.getName(), S3Object.getKey()));
			InputStream objectData = object.getObjectContent();
		
			Core.storeFileDocumentContent(getContext(), OutputS3FileDocument.getMendixObject(), objectData);
		}
		finally
		{
			if (object != null)
				object.close();
		}
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "JAV_GetObject_FileContent";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
