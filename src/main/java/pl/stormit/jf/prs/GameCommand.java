package pl.stormit.jf.prs;

public enum GameCommand {
	PAPER("paper"), ROCK("rock"), SCISSORS("scissors"), QUITE("q");

	private final String value;

	GameCommand(String value) {
		this.value = value;
	}

	public static GameCommand of(String value){
		for(GameCommand command : values()){
			if(command.value.equals(value)){
				return command;
			}
		}

		throw new IllegalArgumentException("Wrong command "+value);
	}
}
