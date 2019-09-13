package teamcity.plugin.swagger;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.SBuildServer;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.WebControllerManager;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class SwaggerController extends BaseController {
	
	private PluginDescriptor myPluginDescriptor;

	public SwaggerController(
			SBuildServer server, 
			WebControllerManager webControllerManager,
    		PluginDescriptor pluginDescriptor) {
		super(server);
		myPluginDescriptor = pluginDescriptor;
		webControllerManager.registerController("/swagger-ui.html", this);
	}

	@Override
	protected ModelAndView doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String,Object> params = new HashMap<>();		
		params.put("jspHome", myPluginDescriptor.getPluginResourcesPath());
		return new ModelAndView(myPluginDescriptor.getPluginResourcesPath() + "swagger-ui-wrapper.jsp", params);
	}
}