package jsp.customtags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomLabelTag extends SimpleTagSupport {

	StringWriter sw = new StringWriter();

	public CustomLabelTag() {
	}

	@Override
	public void doTag() throws JspException, IOException {
		try {
			JspWriter jspWriter = getJspContext().getOut();
			getJspBody().invoke(sw);
			jspWriter.write(
					"<label style=\"color: #93b32c; font-weight: bold; display: block; width: 150px; float: left;\">");
			jspWriter.write(sw.toString());
			jspWriter.write("</label >");
		} catch (Exception e) {
			e.printStackTrace();
			// stop page from loading further by throwing SkipPageException
			throw new SkipPageException();
		}
	}

}
