package br.com.theodoro.avaliacao.framework.spring;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

import net.sf.jasperreports.engine.JasperPrint;

/**Classe para objetos do tipo CustomJasperView, onde serao contidos, informacoes e metodos para o mesmo.
* 
* @version 1.0
* 
*/
public class CustomJasperView extends JasperReportsMultiFormatView {
	
	/**
	 * format defaul key
	 */
	public static final String DEFAULT_FORMAT_KEY = "format";
	
	/**
	 * filename defaul key
	 */
	public static final String DEFAULT_FILENAME_KEY = "title";
	
	/**
	 * format defaul key private
	 */
	private String formatKey = DEFAULT_FORMAT_KEY;
	
	/**
	 * filename defaul key private
	 */
	private String fileNameKey = DEFAULT_FILENAME_KEY;

	/**
	 * Set a file name for the generated report and set it to the
	 * Content-disposition header. Delegates the render of the report to the
	 * {@link org.springframework.web.servlet.view.jasperreports.
	 * JasperReportsMultiFormatView.renderReport(JasperPrint, Map<String,
	 * Object>, HttpServletResponse)}
	 *
	 * @param populatedReport
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@Override
	protected void renderReport(JasperPrint populatedReport, Map<String, Object> model, HttpServletResponse response)
			throws Exception {

		String format = (String) model.get(this.formatKey);
		if (format == null) {
			throw new IllegalArgumentException("No format format found in model");
		}

		// Prepare response and render report.

		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		String todayYyyyMMddHHmm = LocalDateTime.now().format(f);

		String fileName = (String) model.get(this.fileNameKey);
		if (fileName == null) {
			fileName = "export_";
		}
		fileName = fileName.toUpperCase().replaceAll(" ", "_").concat("-").concat(todayYyyyMMddHHmm);

		StringBuilder contentDisposition = new StringBuilder("inline");
		contentDisposition.append("; filename=");
		contentDisposition.append(fileName).append(".").append(format.toLowerCase());
		response.setHeader(HEADER_CONTENT_DISPOSITION, contentDisposition.toString());

		super.renderReport(populatedReport, model, response);
	}

	/**
	 * Gets format model key-name
	 * 
	 * @return the formatKey
	 */
	public String getFormatKey() {
		return formatKey;
	}

	/**
	 * Gets format model key-name
	 * 
	 * @param formatKey
	 *            the formatKey to set
	 */
	public void setFormatKey(String formatKey) {
		this.formatKey = formatKey;
	}

	/**
	 * Gets file-name model key-name
	 * 
	 * @return the fileNameKey
	 */
	public String getFileNameKey() {
		return fileNameKey;
	}

	/**
	 * Gets file-name model key-name
	 * 
	 * @param fileNameKey
	 *            the fileNameKey to set
	 */
	public void setFileNameKey(String fileNameKey) {
		this.fileNameKey = fileNameKey;
	}
}