% Aplicacion para jugar al poker en prolog
%
%Design by:
%    - Ram�n Costafreda
%    - Marta Gonzalez
%    - Jose Martin
%    - Sergio Gonzalez
%
%Universidad San Pablo Ceu (Madrid)
%
%
%


%:- use_module(library(pce)).




rank([ace,king,queen,jack,10,9,8,7,6,5,4,3,2]).

suit([spades,hearts,diamonds,clubs]).

card(R,S) :- rank(R1), suit(S1), member(R,R1),member(S,S1).

%%  CREAMOS LA BARAJA USANDO EL PRODUCTO CARTESIANO


baraja:- 
        rank(M),
        suit(N),
        findall(card(X,Y), parejas(M,N,(X,Y)),R),
        retractall(inicial_baraja(_)),
        assert(inicial_baraja(R)).
        

parejas(M, N, (X, Y)):-
    miembros(X, M),
    miembros(Y, N).

miembros(X, [X|_]).
miembros(X, [_|R]):- member(X, R).



%%      COGER CARTA DE LA BARAJA Y BORRARLA DE ELLA
cogerCartaAleatoria(NumAleatorio, Carta):-
        inicial_baraja(R),
	nth0(NumAleatorio,R,Carta),
        select(Carta,R,RestoBaraja),
        retractall(inicial_baraja(_)),
        assert(inicial_baraja(RestoBaraja)).

longitud(L):-
	inicial_baraja(R),
	length(R,L).


cogerCartaAleatoria(Carta):-
        inicial_baraja(R),
        length(R,Longitud),
        %writeln(Longitud),
        random(0,Longitud,Carta1),
        %writeln(Carta1),
        nth0(Carta1,R,Carta),
        writeln(Carta),
        select(Carta,R,RestoBaraja),
        retractall(inicial_baraja(_)),
        assert(inicial_baraja(RestoBaraja)).
        %length(RestoBaraja,Popo),

        %writeln('longitud final'),
        %writeln(Popo).



%%      RESULTADO DE JUGADOR
       


%%      DARLE DOS CARTAS A CADA JUGADOR



jugadorCarta(Jugador,[Carta1,Carta2]):-
        retractall(carta_jugador(Jugador,[Carta1,Carta2])),
        assert(carta_jugador(Jugador,[Carta1,Carta2])).
%%      COLOCAMOS 5 CARTAS EN LA MESA

mesa :- retractall(cartasMesa(_)),
%        writeln('********** MESA DE LA PARTIDA ***************'),
        cogerCartaAleatoria(Carta1),
%        writeln(Carta1),
        cogerCartaAleatoria(Carta2),
%        writeln(Carta2),
        cogerCartaAleatoria(Carta3),
%        writeln(Carta3),
        cogerCartaAleatoria(Carta4),
%        writeln(Carta4),
        cogerCartaAleatoria(Carta5),
%        writeln(Carta5),
%        writeln('*********************************************'),
        assert(cartasMesa([Carta1,Carta2,Carta3,Carta4,Carta5])).
  
   
%%      TOTAL DE CARTAS POR JUGADOR


totalCartasJugadores([],[]).
totalCartasJugadores([Jugador|RestoJugadores],[jugadorCarta(Jugador,[Carta1,Carta2|CartasMesa])|RestoJugadoresCartas]):-
                writeln('********** Cartas de jugadores ***************'),
                write('Jugador: '),
                writeln(Jugador),
                writeln('Cartas: '),
                cogerCartaAleatoria(Carta1),
                cogerCartaAleatoria(Carta2),
                writeln(Carta1),
                writeln(Carta2),
                writeln('**********************************************'),
                
                 cartasMesa(CartasMesa),
                 totalCartasJugadores(RestoJugadores,RestoJugadoresCartas).
        
 
jugarPartida(ListaJugadores):-
        baraja,
        retractall(listaJugadores(_)),
        assert(listaJugadores(ListaJugadores)),
        mesa,
        totalCartasJugadores(ListaJugadores,JugadoresCartas),
        %writeln(JugadoresCartas),
        retractall(puntosJugador(_,_,_)),
        winning_hand(JugadoresCartas),
       % compilar(Pokemon),
	%write(Pokemon),
        obtenerGanador(_).     
%%      


all_dif([]).
all_dif([D|Ds]) :-
        dif_from(Ds, D),
        all_dif(Ds).

dif_from([], _).
dif_from([A|As], D) :-
        dif(A, D),
        dif_from(As, D).

%has_pair(card(R,S),[card(R,S1)],[card(R,S),card(R,S1)],[]) :-
%        S\=S1,
%        writeln('caso2'),!.
%has_pair(card(R,S),[card(R1,S1)],[],[card(R,S),card(R1,S1)]) :-
%        writeln('caso 1'),!.
% has_pair(card(R,S),[card(R,S1)|RestHand],[card(R,S),card(R,S1)],RestHand) :-
%         S\=S1, writeln('caso3'),!.
%        
% has_pair(card(R,S),[card(R1,S1)|RestHand],Pair,[card(R1,S1)|RestHand1]) :-
%         R\=R1, writeln('caso recursivo'), writeln(RestHand),
% writeln([card(R1,S1)|RestHand1]),
% has_pair(card(R,S),RestHand,Pair,RestHand1).




select_from([card(R,S)], Cards, [card(R,S)]) :-
	\+ member(card(R,S), Cards),!.

select_from([card(R,S)], Cards, []) :-
        member(card(R,S), Cards),!.

select_from([card(R,S)|Hand], Cards, [card(R,S)|RestHand]) :-
        \+ member(card(R,S), Cards),
        select_from(Hand, Cards, RestHand).

select_from([card(R,S)|Hand], Cards, RestHand) :-
        member(card(R,S), Cards),
        select_from(Hand, Cards, RestHand).



tie_break(Hand1, Hand2, Community) :-
        three_of_a_kind([Hand1|Community]), three_of_a_kind([Hand2|Community]).

highest_card(Hc) :-
        not(three_of_a_kind(Hc)),
        not(one_pair(Hc)).



one_pair(OP, [card(R,S1),card(R,S2)],R) :-
        all_dif([S1,S2]),
        member(card(R,S1), OP),
        member(card(R,S2), OP),!.

two_pairs(TP, [card(R1,S1),card(R1,S2),card(R2,S3),card(R2,S4)],R1,R2) :-
	all_dif([S1,S2]),
	all_dif([R1,R2]),
	all_dif([S3,S4]),
        member(card(R1,S1), TP),
        member(card(R1,S2), TP),
	member(card(R2,S3), TP),
	member(card(R2,S4), TP),!.

best_pair([card(R1,_S1)|_RestPair1], [card(R2,_S2)|_Pair2], Result) :-
        value(R1,V1),
        value(R2,V2),
        ( ( V1 > V2, Result = 1,writeln('Jugador 1 gana a puntos'),!);
        ( V1 = V2, Result = 2,writeln('Empate a puntos'),!);
        ( V1 < V2, Result = 3,writeln('Jugador 2 gana a puntos'),!) ).

three_of_a_kind(TOAK,[card(R,S1),card(R,S2),card(R,S3)]) :-
        all_dif([S1,S2,S3]),
        member(card(R,S1), TOAK),
        member(card(R,S2), TOAK),
        member(card(R,S3), TOAK),!.

full(FULL,[card(R1,S1),card(R1,S2),card(R1,S3),card(R2,S4),card(R2,S5)],R1,R2) :-
	three_of_a_kind(FULL,[card(R1,S1),card(R1,S2),card(R1,S3)]),
	select_from(FULL,[card(R1,S1),card(R1,S2),card(R1,S3)],Resto),
	one_pair(Resto,[card(R2,S4),card(R2,S5)],R2),!.

poker(POKER,[card(R,S1),card(R,S2),card(R,S3),card(R,S4)],R) :-
	all_dif([S1,S2,S3,S4]),
	member(card(R,S1),POKER),
	member(card(R,S2),POKER),
	member(card(R,S3),POKER),
	member(card(R,S4),POKER),!.

flush(F,[card(R1,S),card(R2,S),card(R3,S),card(R4,S),card(R5,S)]) :-
	all_dif([R1,R2,R3,R4,R5]),
	member(card(R1,S),F),
	member(card(R2,S),F),
	member(card(R3,S),F),
	member(card(R4,S),F),
	member(card(R5,S),F),!.


winning_hand([]).
winning_hand([jugadorCarta(Jugador,Hand)|RestoJugadoresCartas]):-
        evaluar_mano(Jugador,Hand),
        winning_hand(RestoJugadoresCartas).

evaluarGanador(L, G) :- 
evaluarGanador(L, gProvisional(jProv, -1,_), G).

evaluarGanador([],gProvisional(Jugador,Resultado,Text), ganador(Jugador,Resultado,Text)):-
        writeln(' '),
        writeln(' '),
        writeln(' '),

        writeln('********** Ganador de la partida ***************'),
                write(Jugador),
                write(' gana la partida con '),
                writeln(Text),
        writeln('************************************************').

evaluarGanador([puntuacion(_Jugador, Puntuacion,_) | R], gProvisional(JProvisional, PProvisional,TextProv), G) :-
        Puntuacion =< PProvisional,
        evaluarGanador(R, gProvisional(JProvisional, PProvisional,TextProv), G), !.


evaluarGanador([puntuacion(Jugador, Puntuacion, Text) | R], gProvisional(_JProvisional, PProvisional,_), G) :-
        Puntuacion > PProvisional,
        evaluarGanador(R, gProvisional(Jugador, Puntuacion,Text), G), !.
        

obtenerGanador(Ganador):-
        findall( puntuacion(J, P , V), puntosJugador(J, P, V), Lista),
        %writeln(Lista),
        evaluarGanador(Lista, Ganador).

reevaluar_mano(Jugador, Hand1, Comunitarias) :-
	puntosJugador(Jugador,Mano1,_Value1,TextMano1),
	write('El jugador '), write(Jugador), write(' tenia '),write(TextMano1),
	retractall(puntosJugador(Jugador,_,_)),
	select_from(Hand1,Mano1,NuevaHand1),
	select_from(Comunitarias,Mano1,NuevaComunitarias),
	evaluar_mano(Jugador, NuevaHand1, NuevaComunitarias),
	puntosJugador(Jugador,_Mano2,_Value2,TextMano2),
	write('El jugador '), write(Jugador), write(' tenia '),write(TextMano2).
	

evaluar_mano(Jugador, Hand1, Comunitarias) :-
            retractall(puntosJugador(Jugador,_,_)),
             append(Hand1, Comunitarias, Todas),
             (   (   straight_flush(Todas,StraightFlush,_R), \+ straight_flush(Comunitarias, StraightFlush, _R),
		      highestHand(straightflush, Value),
      		      assert(puntosJugador(Jugador,Value,'straight flush')),
		      assert(puntosJugador(Jugador,StraightFlush,Value,'straight flush')),!);
	     (   royal_flush(Todas,RoyalFlush), \+ royal_flush(Comunitarias, RoyalFlush),
		      highestHand(royalflush, Value),
      		      assert(puntosJugador(Jugador,Value,'royal flush')),
		      assert(puntosJugador(Jugador,RoyalFlush,Value,'royal flush')),!);
	     (   straight(Todas,Straight,_R), \+ straight(Comunitarias, Straight, _R),
		      highestHand(straight, Value),
      		      assert(puntosJugador(Jugador,Value,'straight')),
		      assert(puntosJugador(Jugador,Straight,Value,'straight')),!);
	     (   poker(Todas,Poker,_R),
		      highestHand(poker, Value),
      		      assert(puntosJugador(Jugador,Value,'poker')),
		      assert(puntosJugador(Jugador,Poker,Value,'poker')),!);
	     (    flush(Todas,Flush),
		      highestHand(flush, Value),
      		      assert(puntosJugador(Jugador,Value,'flush')),
		      assert(puntosJugador(Jugador,Flush,Value,'flush')),!);
	     (    full(Todas,Full,_R1,_R2),
		      highestHand(full, Value),
      		      assert(puntosJugador(Jugador,Value,'full')),
		      assert(puntosJugador(Jugador,Full,Value,'full')),!);
	     (    two_pairs(Todas,TP,R1,R2), \+ two_pairs(Comunitarias, TP, R1,R2),
		      highestHand(twopairs, Value),
      		      assert(puntosJugador(Jugador,Value,'dobles parejas')),
		      assert(puntosJugador(Jugador,TP,Value,'dobles parejas')),!);
	     (    three_of_a_kind(Todas,Trio), \+ three_of_a_kind(Comunitarias,Trio),
		      highestHand(threeofakind, Value),
      		      assert(puntosJugador(Jugador,Value,'trio')),
		      assert(puntosJugador(Jugador,Trio,Value,'trio')),!);
	     (   one_pair(Todas,Pareja,R), \+ one_pair(Comunitarias,Pareja,R) ,
		      highestHand(pair,R ,Value),
		      assert(puntosJugador(Jugador,Pareja,Value,'pareja')),
		      assert(puntosJugador(Jugador,Value,'pareja')),!);
             (   highestHand(Hand1, Value), 
		 assert(puntosJugador(Jugador,Value,'carta alta')),!)).
        
        
partidilla :-
	Comunitarias = [card(2,diamonds),card(3,hearts),card(4,clubs),card(5,clubs),card(7,hearts)],
	YoCartas = [card(7,spades),card(6,diamonds)],
	ElotroCartas = [card(8,hearts),card(5,clubs)],
	writeln(Comunitarias),
	writeln(YoCartas),
	writeln(ElotroCartas),
	evaluar_mano(yo,YoCartas,Comunitarias),
	puntosJugador(yo,V,M),
	write('yo_value es '),write(V),write(' y yo_mano es '),writeln(M),
	evaluar_mano(elotro,ElotroCartas,Comunitarias),
	puntosJugador(elotro,V2,M2),
	write('elotro_value es '),write(V2),write(' y elotro_mano es '),writeln(M2).

royal_flush(RF,[card(ace,S),card(king,S),card(queen,S),card(jack,S),card(10,S)]) :-
	member(card(ace,S),RF),
	member(card(king,S),RF),
	member(card(queen,S),RF),
	member(card(jack,S),RF),
	member(card(10,S),RF),!.


straight_flush(SF,[card(R1,S),card(R2,S),card(R3,S),card(R4,S),card(R5,S)],R5) :-
	member(card(R1,S),SF),
	highestHand(card(R1,S),Value1),
	member(card(R2,S),SF),
	highestHand(card(R2,S),Value2),
	member(card(R3,S),SF),
	highestHand(card(R3,S),Value3),
	member(card(R4,S),SF),
	highestHand(card(R4,S),Value4),
	member(card(R5,S),SF),
	highestHand(card(R5,S),Value5),
	Value1+1 =:= Value2,
	Value2+1 =:= Value3,
	Value3+1 =:= Value4,
	Value4+1 =:= Value5,!.
	

straight(S,[card(R1,S1),card(R2,S2),card(R3,S3),card(R4,S4),card(R5,S5)],R5) :-
	member(card(R1,S1),S),
	highestHand(card(R1,S1),Value1),
	member(card(R2,S2),S),
	highestHand(card(R2,S2),Value2),
	member(card(R3,S3),S),
	highestHand(card(R3,S3),Value3),
	member(card(R4,S4),S),
	highestHand(card(R4,S4),Value4),
	member(card(R5,S5),S),
	highestHand(card(R5,S5),Value5),
	Value1+1 =:= Value2,
	Value2+1 =:= Value3,
	Value3+1 =:= Value4,
	Value4+1 =:= Value5,!.
	


% Mano : Valor

highestHand(card(1,_S),1).
highestHand(card(2,_S),2).
highestHand(card(3,_S),3).
highestHand(card(4,_S),4).
highestHand(card(5,_S),5).
highestHand(card(6,_S),6).
highestHand(card(7,_S),7).
highestHand(card(8,_S),8).
highestHand(card(9,_S),9).
highestHand(card(10,_S),10).
highestHand(card(jack,_S),11).
highestHand(card(queen,_S),12).
highestHand(card(king,_S),13).
highestHand(card(ace,_S),14).



highestHand(pair,2,22).
highestHand(pair,3,23).
highestHand(pair,4,24).
highestHand(pair,5,25).
highestHand(pair,6,26).
highestHand(pair,7,27).
highestHand(pair,8,28).
highestHand(pair,9,29).
highestHand(pair,10,30).
highestHand(pair,jack,31).
highestHand(pair,queen,32).
highestHand(pair,king,33).
highestHand(pair,ace,34).

highestHand(twopairs,40).

highestHand(threeofakind,50).

highestHand(straight, 55).

highestHand(flush,60).

highestHand(full,70).

highestHand(poker,80).

highestHand(straightflush, 90).

highestHand(royalflush, 100).

highestHand([card(R1,S1)], Resultado) :-
        highestHand(card(R1,S1),Value1),
        Resultado is Value1,!.
                
highestHand([card(R1,S1)|RestHand],Resultado) :-
        highestHand(card(R1,S1),Value1),
        highestHand(RestHand,Resultado1),
        (   (   Resultado1 < Value1, 
        Resultado is Value1);
        (   Resultado1 >= Value1, Resultado is Resultado1)).



save(Exe) :-
        pce_autoload_all,
        pce_autoload_all,
        qsave_program(Exe,
                      [ emulator(swi('bin/xpce-stub.exe')),
                        stand_alone(true),
                        goal(main)
                      ]).



compilar(P):-
  qsave_program(P,[
    local(0),
    global(0),
    trail(0),
    argument(0),
    goal(pce_main_loop(main)),
    class(kernel),
    autoload(true),
    op(save),
    stand_alone(true),
    emulator('bin/xpce-stub.exe')
  ]).









