package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author YZX
 * @date 2019��9��19��
 * @time ����9:02:15
 */

public class IOStreamTest {
	public static void copyFileUseNIO(String src, String dst) throws IOException {
		// ����Դ�ļ���Ŀ���ļ�
		FileInputStream fi = new FileInputStream(new File(src));
		FileOutputStream fo = new FileOutputStream(new File(dst));
		// ��ô���ͨ��channel
		FileChannel inChannel = fi.getChannel();
		FileChannel outChannel = fo.getChannel();
		// �������buffer
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			// �ж��Ƿ�����ļ�
			int eof = inChannel.read(buffer);
			if (eof == -1) {
				break;
			}
			// ����һ��buffer��position=0��limit=position
			buffer.flip();
			// ��ʼд
			outChannel.write(buffer);
			// д��Ҫ����buffer������position=0,limit=capacity
			buffer.clear();
		}
		inChannel.close();
		outChannel.close();
		fi.close();
		fo.close();
	}
}
