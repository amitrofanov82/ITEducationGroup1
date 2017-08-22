package specialtasks.edinorog;

public class TaskResolverZhigimont {

	public static String resolveOneCase(String caseInput) {
		// e.g. caseInput = 6 2 0 2 0 2 0
		String[] inputAsArray = caseInput.split(" ");
		int N = Integer.parseInt(inputAsArray[0]); // кол-во единорогов
		int R = Integer.parseInt(inputAsArray[1]); // кол-во красногривых
		int O = Integer.parseInt(inputAsArray[2]); // кол-во оранжевогривых
		int Y = Integer.parseInt(inputAsArray[3]); // кол-во желтогривых
		int G = Integer.parseInt(inputAsArray[4]); // кол-во зеленогривых
		int B = Integer.parseInt(inputAsArray[5]); // кол-во голубогривых
		int V = Integer.parseInt(inputAsArray[6]); // кол-во фиолетовогривых

		String answer = resolveTask(N, R, O, Y, G, B, V);

		return answer;
	}

	private static String resolveTask(int N, int R, int O, int Y, int G, int B, int V) {
		char[] stall = new char[N];
		if (O >= B && O != 0) {
			if (R != 0 || Y != 0) {
				return "IMPOSSIBLE";
			} else if (R == 0 && Y == 0) {
				if (O == B) {
					stall[0] = 'O';
					O--;
				} else
					return "IMPOSSIBLE";
			}
		} else if (G >= R && G != 0) {
			if (B != 0 || Y != 0) {
				return "IMPOSSIBLE";
			} else if (B == 0 && Y == 0) {
				if (G == R) {
					stall[0] = 'G';
					G--;
				} else
					return "IMPOSSIBLE";
			}
		} else if (V >= Y && V != 0) {
			if (B != 0 || R != 0) {
				return "IMPOSSIBLE";
			} else if (B == 0 && R == 0) {
				if (V == Y) {
					stall[0] = 'V';
					V--;
				} else
					return "IMPOSSIBLE";
			}
		} else if (B >= O && R >= G && Y >= V) {
			if (O == 0 && G == 0 && V == 0) {
				if (B >= R && B >= Y) {
					if (B - 1 < R + Y) {
						stall[0] = 'B';
						B--;
					} else if (B - 1 >= R + Y) {
						return "IMPOSSIBLE";
					}
				} else if (R >= B && R >= Y) {
					if (R - 1 < B + Y) {
						stall[0] = 'R';
						R--;
					} else if (R - 1 >= B + Y) {
						return "IMPOSSIBLE";
					}
				} else if (Y >= B && Y >= R) {
					if (Y - 1 < B + R) {
						stall[0] = 'Y';
						Y--;
					} else if (Y - 1 >= R + B) {
						return "IMPOSSIBLE";
					}
				}
			} else if (B != 0 && R != 0 && Y != 0) {
				if (B - O <= ((Y - V) + (R - G))) {
					if (R - G <= ((Y - V) + (B - O))) {
						if (Y - V <= ((B - O) + (R - G))) {
							if (B >= R && B >= Y) {
								stall[0] = 'B';
								B--;
							} else if (R >= B && R >= Y) {
								stall[0] = 'R';
								R--;
							} else if (Y >= B && Y >= R) {
								stall[0] = 'Y';
								Y--;
							}
						} else {
							return "IMPOSSIBLE";
						}
					} else {
						return "IMPOSSIBLE";
					}
				} else {
					return "IMPOSSIBLE";
				}
			} else if (B != 0 && R == 0 && Y == 0) {
				if (B == O) {
					stall[0] = 'B';
					B--;
				} else {
					return "IMPOSSIBLE";
				}
			} else if (Y != 0 && B == 0 && R == 0) {
				if (Y == V) {
					stall[0] = 'Y';
					Y--;
				} else {
					return "IMPOSSIBLE";
				}
			} else if (R != 0 && B == 0 && Y == 0) {
				if (R == G) {
					stall[0] = 'R';
					R--;
				} else {
					return "IMPOSSIBLE";
				}
			} else if (B >= R && B >= Y) {
				if (B != 0) {
					if (Y == 0 && Y == V) {
						if (R - G == B - O) {
							stall[0] = 'B';
							B--;
						} else {
							return "IMPOSSIBLE";
						}
					}
					if (R == 0 && R == G) {
						if (Y - V == B - O) {
							stall[0] = 'B';
							B--;
						} else {
							return "IMPOSSIBLE";
						}
					} 
				}
			} else if (R >= B && R >= Y) {
				if (R != 0) {
					if (Y == 0 && Y == V) {
						if (R - G == B - O) {
							stall[0] = 'R';
							R--;
						} else {
							return "IMPOSSIBLE";
						}
					}
					if (B == 0 && B == O) {
						if (R - G == Y - V) {
							stall[0] = 'R';
							R--;

						} else {
							return "IMPOSSIBLE";
						}
					} 
				}
			} else if (Y >= B && Y >= R) {
				if (Y != 0) {
					if (R == 0 && R == G) {
						if (Y - V == B - O) {
							stall[0] = 'Y';
							Y--;
						} else {
							return "IMPOSSIBLE";
						}
					}
					if (B == 0 && B == O) {
						if (Y - V == R - G) {
							stall[0] = 'Y';
							Y--;
						} else {
							return "IMPOSSIBLE";
						}
					} 
				}
			}
		} else {
			return "IMPOSSIBLE";
		}

		for (int i = 1; i < stall.length; i++) {
			if (stall[i - 1] == 'B') {
				if (O != 0) {
					stall[i] = 'O';
					O--;
				} else if (R != 0 && R - G >= Y - V) {
					if (stall[0] == 'Y' && Y == 1) {
						if (stall[i - 1] == 'B' || stall[i - 1] == 'R') {
							stall[i] = 'Y';
							Y--;
						} else {
							stall[i] = 'R';
							R--;
						}
					} else {
						stall[i] = 'R';
						R--;
					}
				} else if (Y != 0) {
					stall[i] = 'Y';
					Y--;
				}
			} else if (stall[i - 1] == 'Y') {
				if (V != 0) {
					stall[i] = 'V';
					V--;
				} else if (B != 0 && B - O >= R - G) {
					if (stall[0] == 'R' && R == 1) {
						if (stall[i - 1] == 'Y' || stall[i - 1] == 'B') {
							stall[i] = 'R';
							R--;
						} else {
							stall[i] = 'B';
							B--;
						}
					} else {
						stall[i] = 'B';
						B--;
					}
				} else if (R != 0) {
					stall[i] = 'R';
					R--;
				}
			} else if (stall[i - 1] == 'R') {
				if (G != 0) {
					stall[i] = 'G';
					G--;
				} else if (Y != 0 && Y - V >= B - O) {
					if (stall[0] == 'B' && B == 1) {
						if (stall[i - 1] == 'Y' || stall[i - 1] == 'R') {
							stall[i] = 'B';
							B--;
						} else {
							stall[i] = 'Y';
							Y--;
						}
					} else {
						stall[i] = 'Y';
						Y--;
					}
				} else if (B != 0) {
					stall[i] = 'B';
					B--;
				}
			} else if (stall[i - 1] == 'O') {
				stall[i] = 'B';
				B--;
			} else if (stall[i - 1] == 'V') {
				stall[i] = 'Y';
				Y--;
			} else if (stall[i - 1] == 'G') {
				stall[i] = 'R';
				R--;
			}
		}
		String result = new String(stall);

		return result;
	}

}