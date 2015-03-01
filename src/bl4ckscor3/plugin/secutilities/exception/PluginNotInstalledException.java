package bl4ckscor3.plugin.secutilities.exception;

public class PluginNotInstalledException extends Exception
{
	private static final long serialVersionUID = 2061097222301896974L;

	public PluginNotInstalledException(String name)
	{
		super(name + " is not installed. This is a serious issue and should be resolved as soon as possible.");
	}
}
