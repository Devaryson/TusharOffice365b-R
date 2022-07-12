package email.code;

import java.io.File;

import javax.net.ssl.SSLSocketFactory;

import com.aspose.email.Attachment;
import com.aspose.email.EmailClient;
import com.aspose.email.IConnection;
import com.aspose.email.ImapClient;
import com.aspose.email.ImapMessageInfo;
import com.aspose.email.ImapMessageInfoCollection;
import com.aspose.email.MailMessage;
import com.aspose.email.MapiAttachment;
import com.aspose.email.SecurityOptions;
import com.aspose.email.system.IAsyncResult;

public class test {
public static void main(String[] args) {
	ImapClient client = new ImapClient("imap.mail.me.com", 993,"poojatester2021@icloud.com", "dljbkufkddvwqten");
	client.setSecurityOptions(SecurityOptions.Auto);

EmailClient.setSocketsLayerVersion2(true);

	client.setTimeout(5 * 60 * 1000);
	EmailClient.setSocketsLayerVersion2(false);
	EmailClient.setSocketsLayerVersion2SSLSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
	IConnection iconection= client.createConnection();
	System.out.println("connection establis");
	
	   ImapMessageInfoCollection messageInfoCol = client.listMessages("Inbox");
	    for  (ImapMessageInfo info : messageInfoCol)
	    {
	    	MailMessage msg2 = null;


				msg2 = client.fetchMessage(
						info.getSequenceNumber(),true);
				
				System.out.println(msg2.getAttachments().size());
				for (int j = 0; j < msg2.getAttachments().size(); j++) {
					Attachment att = msg2.getAttachments().get_Item(j);

					String s = Main_Frame.getFileExtension(att.getName());
					
					IAsyncResult  aaa=			client.beginFetchAttachment(info.getSequenceNumber(),att.getName());
					Attachment attaa=(Attachment)aaa; 
//					String attFileName = Main_Frame
//							.getRidOfIllegalFileNameCharacters(att.getName().replace("." + s, ""));

//					att.save("C:\\Users\\Admin\\Desktop\\hi"
//							+ File.separator + attFileName);

				}
	       
	    }
	}

	}


