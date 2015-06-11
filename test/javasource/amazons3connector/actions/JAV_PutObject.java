// This file was generated by Mendix Business Modeler.
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
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * 
 */
public class JAV_PutObject extends CustomJavaAction<Boolean>
{
	private IMendixObject __AwsConfigParameter1;
	private amazons3connector.proxies.AwsConfig AwsConfigParameter1;
	private IMendixObject __S3BucketParameter1;
	private amazons3connector.proxies.S3Bucket S3BucketParameter1;
	private IMendixObject __S3SummaryObjectParameter1;
	private amazons3connector.proxies.S3SummaryObject S3SummaryObjectParameter1;
	private IMendixObject __S3FileDocumentParameter1;
	private amazons3connector.proxies.S3FileDocument S3FileDocumentParameter1;

	public JAV_PutObject(IContext context, IMendixObject AwsConfigParameter1, IMendixObject S3BucketParameter1, IMendixObject S3SummaryObjectParameter1, IMendixObject S3FileDocumentParameter1)
	{
		super(context);
		this.__AwsConfigParameter1 = AwsConfigParameter1;
		this.__S3BucketParameter1 = S3BucketParameter1;
		this.__S3SummaryObjectParameter1 = S3SummaryObjectParameter1;
		this.__S3FileDocumentParameter1 = S3FileDocumentParameter1;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		this.AwsConfigParameter1 = __AwsConfigParameter1 == null ? null : amazons3connector.proxies.AwsConfig.initialize(getContext(), __AwsConfigParameter1);

		this.S3BucketParameter1 = __S3BucketParameter1 == null ? null : amazons3connector.proxies.S3Bucket.initialize(getContext(), __S3BucketParameter1);

		this.S3SummaryObjectParameter1 = __S3SummaryObjectParameter1 == null ? null : amazons3connector.proxies.S3SummaryObject.initialize(getContext(), __S3SummaryObjectParameter1);

		this.S3FileDocumentParameter1 = __S3FileDocumentParameter1 == null ? null : amazons3connector.proxies.S3FileDocument.initialize(getContext(), __S3FileDocumentParameter1);

		// BEGIN USER CODE
		AmazonS3 s3client = AmazonHelper.GetS3Client(AwsConfigParameter1);
		
		InputStream input = Core.getFileDocumentContent(getContext(), S3FileDocumentParameter1.getMendixObject());
		
		s3client.putObject(new PutObjectRequest(S3BucketParameter1.getName(), S3SummaryObjectParameter1.getKey(),
				input, new ObjectMetadata()));
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "JAV_PutObject";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
