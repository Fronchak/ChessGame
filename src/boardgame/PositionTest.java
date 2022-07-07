package boardgame;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PositionTest {

	private Position position;
	
	@BeforeEach
	public void setup() {
		this.position = new Position(3, 3);
	}
	
	@ParameterizedTest	
	@MethodSource("argumentosParaTestarOffSet")
	public void aplicadoUmValorDeOffsetDeveFazerAPosicaoAlterar(int row, int column, Position finalPosition) {
		position.offset(row, column);
		Assertions.assertEquals(finalPosition, position);
	}
	
	public static Stream<Arguments> argumentosParaTestarOffSet(){
		return Stream.of(Arguments.of(1, 0, new Position(4, 3)), 
				Arguments.of(1, 1, new Position(4, 4)), 
				Arguments.of(-2, -1, new Position(1, 2)));
	}
}
