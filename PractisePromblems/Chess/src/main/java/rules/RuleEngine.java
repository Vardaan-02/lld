package main.java.rules;

import main.java.dto.MoveIntent;
import main.java.models.GameSession;

public interface RuleEngine {
    boolean processTurn(GameSession session, MoveIntent intent);
}