package analyzer;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerAnalyzerTest {

    private PlayerAnalyzer playerAnalyzer;

    @BeforeEach
    public void setup() {
        playerAnalyzer = new PlayerAnalyzer();
    }

    @Test
    public void normalPlayerTest() {
        Player player = new Player();
        player.setAge(25);
        player.setExperience(5);
        player.setSkills(Arrays.asList(2, 2, 2));

        List<Player> players = List.of(player);

        double result = playerAnalyzer.calculateScore(players);
        assertEquals(250, result);
    }

    @Test
    public void juniorPlayerTest() {
        Player player = new Player();
        player.setAge(15);
        player.setExperience(3);
        player.setSkills(Arrays.asList(3, 3, 3));

        List<Player> players = List.of(player);

        double result = playerAnalyzer.calculateScore(players);
        assertEquals(67.5, result);
    }

    @Test
    public void seniorPlayerTest() {
        Player player = new Player();
        player.setAge(35);
        player.setExperience(15);
        player.setSkills(Arrays.asList(4, 4, 4));

        List<Player> players = Arrays.asList(player);

        double result = playerAnalyzer.calculateScore(players);
        assertEquals(2520, result);
    }

    @Test
    public void multiplePlayersTest() {
        Player player1 = new Player();
        player1.setAge(25);
        player1.setExperience(5);
        player1.setSkills(Arrays.asList(2, 2, 2));

        Player player2 = new Player();
        player2.setAge(15);
        player2.setExperience(3);
        player2.setSkills(Arrays.asList(3, 3, 3));

        List<Player> players = Arrays.asList(player1, player2);

        double result = playerAnalyzer.calculateScore(players);
        assertEquals(250 + 67.5, result);
    }

    @Test
    public void skillsIsNullTest() {
        Player player = new Player();
        player.setAge(25);
        player.setExperience(5);
        player.setSkills(null);

        List<Player> players = List.of(player);

        assertThrows(NullPointerException.class, () -> {
            playerAnalyzer.calculateScore(players);
        });
    }

    @Test
    public void Test() {
        List<Player> players = List.of();
        double result = playerAnalyzer.calculateScore(players);
        assertEquals(0, result);
    }
}
