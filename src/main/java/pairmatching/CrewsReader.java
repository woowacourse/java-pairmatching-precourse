package pairmatching;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CrewsReader {
	private static final String BACKEND_CREW_FILE = "backend-crew.md";
	private static final String FRONT_CREW_FILE = "frontend-crew.md";
	private static final ClassLoader CLASS_LOADER = Application.class.getClassLoader();

	public List<String> readBackendCrews() {
		return readCrews(BACKEND_CREW_FILE);
	}

	public List<String> readFrontCrews() {
		return readCrews(FRONT_CREW_FILE);
	}

	private List<String> readCrews(String fileName) {
		FileInputStream fileInputStream = createFileInputStream(fileName);
		BufferedReader reader = createBufferedReader(fileInputStream);
		try {
			return readFile(reader);
		} catch (IOException e) {
			throw new IllegalStateException(fileName + " 파일을 읽는 도중 실패했습니다.");
		} finally {
			closeResources(fileInputStream, reader);
		}
	}

	private FileInputStream createFileInputStream(String fileName) {
		try {
			return new FileInputStream(CLASS_LOADER.getResource(fileName).getFile());
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(fileName + " 파일이 없습니다.");
		}
	}

	private BufferedReader createBufferedReader(FileInputStream file) {
		try {
			return new BufferedReader(new InputStreamReader(file, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	private List<String> readFile(BufferedReader reader) throws IOException {
		List<String> crews = new ArrayList<>();
		String line = null;
		while ((line = reader.readLine()) != null) {
			crews.add(line);
		}
		return crews;
	}

	private void closeResources(FileInputStream file, BufferedReader reader) {
		try {
			file.close();
			reader.close();
		} catch (IOException e) {
			throw new IllegalStateException("파일 자원을 해제하는 중 에러가 발생했습니다.", e);
		}
	}
}
