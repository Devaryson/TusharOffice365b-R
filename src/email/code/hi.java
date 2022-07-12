package email.code;

import java.io.File;

//import java.util.Iterator;

import com.aspose.email.FolderInfo;
import com.aspose.email.FolderInfoCollection;
import com.aspose.email.PersonalStorage;


public class hi {
	static String path = "";
	static PersonalStorage ost =null;
	public static void main(String[] args) {

		PersonalStorage pst = PersonalStorage.fromFile("C:\\Users\\NEW\\Downloads\\ranjankraryson@outlook.com (1).ost");
		 ost = PersonalStorage.create("C:\\\\Users\\\\NEW\\\\Downloads\\\\ras.pst", 0);

		FolderInfoCollection folderInf = pst.getRootFolder().getSubFolders();

		for (int j = 0; j < folderInf.size(); j++) {
			FolderInfo folderInfo = folderInf.get_Item(j);

			path=folderInfo.getDisplayName();
			
			if (folderInfo.hasSubFolders()) {

				subfolder(folderInfo);
			}

		}

	}

	static void subfolder(FolderInfo folderInfo) {

		FolderInfoCollection folderInf = folderInfo.getSubFolders();

		for (int i = 0; i < folderInf.size(); i++) {

			FolderInfo folderIn = folderInf.get_Item(i);
			if (folderIn.getDisplayName().equalsIgnoreCase("ipm_subtree") && folderIn.hasSubFolders()) {
path=path+File.separator+folderIn.getDisplayName();
System.out.println(path);

break;
				//subfolder1(folderIn);
				

			}

		}

	}

	static void subfolder1(FolderInfo folderInfo) {

		FolderInfoCollection folderInf = folderInfo.getSubFolders();

		for (int i = 0; i < folderInf.size(); i++) {

			FolderInfo folderIn = folderInf.get_Item(i);
			path = folderIn.getDisplayName();
			
		if(path.contains("Delete")){
			ost.getRootFolder().getSubFolder(path,true);
		}else {
			ost.getRootFolder().addSubFolder(path,true);
			
		}
System.out.println(path);
			if (folderIn.hasSubFolders()) {

				subfolder2(folderIn);

			}

		}

	}
	
	
	
	
	static void subfolder2(FolderInfo folderInfo) {

		FolderInfoCollection folderInf = folderInfo.getSubFolders();

		for (int i = 0; i < folderInf.size(); i++) {

			FolderInfo folderIn = folderInf.get_Item(i);
			path = path+java.io.File.separator+folderIn.getDisplayName();
			
			ost.getRootFolder().addSubFolder(path,true);
			System.out.println(path);
			if (folderIn.hasSubFolders()) {

				subfolder2(folderIn);

			}
			removefolder(path);
		}

	}
	
static	public String removefolder(String path) {

		String[] str1;
		
			str1 = path.split("\\\\");
		

		for (int j = 0; j < str1.length; j++) {

			if (j == 0) {
				path = str1[j];
			} else if (!(j == str1.length - 1)) {
				path = path + File.separator + str1[j];
			}
		}
		return path;
	}
	

}
