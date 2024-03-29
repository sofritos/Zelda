import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Screen2{


private Enemy spider[];
private BufferedImage img[];
private final int SPRITE_WIDTH=50;
private final int SPRITE_HEIGHT=50;
private int level;
private Items coins[];
private Sword sword;
private Health hearts[];

private int map[][]={
			{0,0,0,0,0,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,0,0,0,0,0},
			{0,0,0,0,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,0,0,0,0},
			{0,0,0,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,0,0,0},
			{0,0,3,3,3,3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,3,3,3,0,0},
			{0,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,0},
			{3,3,3,3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,3,3,3},
			{3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,3},
			{3,3,2,1,1,1,1,1,4,5,1,1,1,1,1,1,1,1,1,1,4,5,1,1,1,1,1,2,3,3},
			{1,1,1,1,1,1,1,1,6,7,1,1,1,1,1,1,1,1,1,1,6,7,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,4,5,1,1,1,1,1,1,1,1,1,1,4,5,1,1,1,1,1,1,1,1},
			{3,3,1,1,1,1,1,1,6,7,1,1,1,1,1,1,1,1,1,1,6,7,1,1,1,1,1,1,3,3},
			{3,3,3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,3,3},
			{0,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,0},
			{0,0,3,3,3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,3,3,0,0},
			{0,0,0,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,0,0,0},
			{0,0,0,0,3,3,3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,3,3,3,0,0,0,0},
			{0,0,0,0,0,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,0,0,0,0,0},
};

private int map4[][]={
        {9,9,9,9,9,9,9,9,9,1,1,1,1,1,1,1,1,1,1,1,1,9,9,9,9,9,9,9,9,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,8,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
        {9,8,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,8,8,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,8,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,8,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
        {9,8,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,12,13,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,11,10,0,0,9},
        {9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9},
        {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,0,0,0,0,0,9,9,9,9,9,9,9,9},

};

private int map6[][]={
		{18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,0,0,0,0,0,18,18,18,18,18,18,18,18},
		{18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,30,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,32,20,20,32,32,32,32,32,31,18},
		{15,15,15,15,15,15,15,15,15,15,15,20,15,15,15,15,15,15,15,15,15,20,20,15,15,15,15,15,15,15},
		{15,15,15,15,15,15,15,15,20,15,15,15,15,15,15,15,15,15,15,15,15,20,20,15,15,15,15,15,20,15},
		{15,20,15,15,15,15,15,15,15,15,15,15,15,20,15,15,15,15,15,15,15,20,20,15,15,15,15,15,15,15},
		{15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,20,15,15,15,15,20,20,15,15,15,15,15,15,15},
		{15,15,15,15,15,15,15,20,15,15,15,15,15,15,15,15,15,15,15,15,15,20,20,15,15,20,15,15,15,15},
		{15,15,15,20,15,15,15,15,15,15,15,15,20,15,15,15,15,15,15,15,15,20,20,15,15,15,15,15,15,15},
		{15,15,15,15,15,15,20,15,15,15,15,15,15,15,15,15,15,15,15,15,15,20,20,15,15,15,15,15,15,15},
		{18,28,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,20,20,19,19,19,19,19,29,18},
		{18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,18,21,23,24,26,21,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,18,21,22,25,27,21,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18},
		{18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18},
};

private int map7[][]={
		
		{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
		{3,33,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
		{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
				
};

private int map2[][]={
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,14,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
};

private int map3[][]={
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{16,16,16,16,16,0,0,0,16,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,16,0,0,16},
			{16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,0,0,0,0,16},
			{16,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16},
			{16,0,0,0,0,0,0,0,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,1},
			{16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,0,0,0,0,0,1},
			{16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{16,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,0,0,0,0,0,0,0,16,0,0,0,0,1},
			{16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{16,0,0,0,0,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,0,0,0,0,0,0,0,16},
			{16,16,16,16,16,0,0,0,0,0,0,0,16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
			{14,14,14,14,14,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,15},
};

private int map5[][]={
			{18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,17,17,17,17,17},
			{18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,17,17,17,17},
			{17,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,17,17,17},
			{17,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,17,17},
			{17,18,0,0,0,0,0,0,0,0,0,0,0,0,18,18,18,18,18,18,18,18,0,0,0,0,0,0,18,17},
			{17,17,18,0,0,0,0,0,0,0,0,0,0,18,0,0,0,0,0,0,0,0,18,0,0,0,0,0,0,18},
			{17,17,17,18,0,0,0,0,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,18,0,0,0,0,0,0},
			{18,18,18,18,0,0,0,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,18,0,0,0,0,0,0},
			{1,0,0,0,18,0,0,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,0,18,0,0,0,0,0},
			{1,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,0,0,0,0},
			{1,0,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,0,0,0},
			{1,0,0,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,0,0},
			{1,0,0,0,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,0,0,0},
			{1,0,0,0,0,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,0,0,0,0},
			{18,18,18,18,0,0,0,0,0,0,18,0,0,0,0,0,0,0,0,0,0,0,18,18,18,0,0,0,0,0},
			{17,17,17,17,18,0,0,0,0,0,0,18,18,18,18,18,18,18,18,18,18,18,18,0,0,0,0,0,0,0},
			{17,17,17,17,17,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{17,17,17,17,17,17,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,18,18},
			{17,17,17,17,17,17,17,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,17,17,17},
			{17,17,17,17,17,17,17,17,18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,17,17,17,17},
			{17,17,17,17,17,17,17,17,17,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,17,17,17,17,17},
};


public Screen2(){
	img =new BufferedImage[34];
 try {
     img[0] = ImageIO.read(new File("images/desertqt.gif")); System.out.println("0");
     img[1] = ImageIO.read(new File("images/dirtqt.png"));
     img[2] = ImageIO.read(new File("images/graveqt.png"));
     img[3] = ImageIO.read(new File("images/white rockqt.png"));
     img[4] = ImageIO.read(new File("images/topleftshrine..png"));
     img[5] = ImageIO.read(new File("images/toprightshrine.png"));
     img[6] = ImageIO.read(new File("images/bottomleftshrine.png"));
     img[7] = ImageIO.read(new File("images/bottomrightshrine.png"));
     img[8] = ImageIO.read(new File("images/StairsV.gif"));
     img[9] = ImageIO.read(new File("images/snailqt.gif"));
     img[10] = ImageIO.read(new File("images/BRTreeD.gif"));
     img[11] = ImageIO.read(new File("images/BLTreeD.gif"));
     img[12] = ImageIO.read(new File("images/TLTreeD.gif"));
     img[13] = ImageIO.read(new File("images/TRTreeD.gif"));
     img[14] = ImageIO.read(new File("images/BCrock.gif")); 
     img[15] = ImageIO.read(new File("images/CCwateR.gif"));
     img[16] = ImageIO.read(new File("images/TreeR.gif"));
	 img[17] = ImageIO.read(new File("images/greenrockqt.png"));
	 img[18] = ImageIO.read(new File("images/TreeG.gif"));
	 img[19] = ImageIO.read(new File("images/BCwaterR.gif"));
	 img[20] = ImageIO.read(new File("images/BridgeG.gif"));
	 img[21] = ImageIO.read(new File("images/GreenK.gif"));
	 img[22] = ImageIO.read(new File("images/BLtikig.gif"));
	 img[23] = ImageIO.read(new File("images/TLtikig.gif"));
	 img[24] = ImageIO.read(new File("images/TCtikig.gif"));
	 img[25] = ImageIO.read(new File("images/CenterTree.gif"));
	 img[26] = ImageIO.read(new File("images/TRtikig.gif"));
	 img[27] = ImageIO.read(new File("images/BRtikig.gif"));
	 img[28] = ImageIO.read(new File("images/BLwaterR.gif"));
	 img[29] = ImageIO.read(new File("images/BRwaterR.gif"));
	 img[30] = ImageIO.read(new File("images/TLwaterR.gif"));
	 img[31] = ImageIO.read(new File("images/TRwaterR.gif"));
	 img[32] = ImageIO.read(new File("images/TCwaterR.gif"));
	 img[33] = ImageIO.read(new File("images/StairV2.gif"));
   }catch (IOException e)
 {
   e.printStackTrace();
}
	level=1;

}

public int getLevel(){return level;}
public void setLevel(int i){
	level = i;
	switch (i) {
		case 1:
		coins=new Items[3];
	coins[0]=new Items(750,822);
	coins[1]=new Items(700,822);
	coins[2]=new Items(650,822);
		spider = new Enemy[20];
	spider[0]=new Enemy(700,100);
	spider[1]=new Enemy(700,150);
	spider[2]=new Enemy(700,200);
	spider[3]=new Enemy(700,250);
	spider[4]=new Enemy(700,300);
	spider[5]=new Enemy(700,350);
	spider[6]=new Enemy(700,400);
	spider[7]=new Enemy(700,600);
	spider[8]=new Enemy(700,650);
	spider[9]=new Enemy(700,700);
	spider[10]=new Enemy(700,750);
	spider[11]=new Enemy(700,800);
	spider[12]=new Enemy(700,850);
	spider[13]=new Enemy(700,250);
	spider[14]=new Enemy(650,300);
	spider[15]=new Enemy(650,350);
	spider[16]=new Enemy(650,400);
	spider[17]=new Enemy(650,600);
	spider[18]=new Enemy(650,650);
	spider[19]=new Enemy(650,700);
	//hearts=new Health[0];
	break;
	
	case 2:
	hearts=new Health[1];
	hearts[0]=new Health(125,150);
	spider = new Enemy[35];
	spider[0]= new Enemy(50,50);
	spider[1]= new Enemy(100,100);
	spider[2]= new Enemy(150,150);
	spider[3]= new Enemy(1400,50,'l');
	spider[4]= new Enemy(1350,100,'l');
	spider[5]= new Enemy(1300,150,'l');
	spider[6]= new Enemy(725,50,'d');
	spider[7]= new Enemy(150,850);
	spider[8]= new Enemy(100,900);
	spider[9]= new Enemy(50,950);
	spider[10]= new Enemy(1300,850,'l');
	spider[11]= new Enemy(1350,900,'l');
	spider[12]= new Enemy(1400,950,'l');
	spider[13]= new Enemy(150,300,'r');
	spider[14]= new Enemy(100,350,'r');
	spider[15]= new Enemy(50,400,'r');
	spider[16]= new Enemy(50,600,'r');
	spider[17]= new Enemy(100,650,'r');
	spider[18]= new Enemy(150,700,'r');
	spider[19]= new Enemy(1400,600,'l');
	spider[20]= new Enemy(1350,650,'l');
	spider[21]= new Enemy(1300,700,'l');
	spider[22]= new Enemy(1300,300,'l');
	spider[23]= new Enemy(1350,350,'l');
	spider[24]= new Enemy(1400,400,'l');
	
	spider[25]= new Enemy(675,400,'u');
	spider[26]= new Enemy(725,350,'u');
	spider[27]= new Enemy(675,300,'u');
	spider[28]= new Enemy(775,300,'u');
	spider[29]= new Enemy(775,400,'u');
	
	spider[30]= new Enemy(675,700,'d');
	spider[31]= new Enemy(725,650,'d');
	spider[32]= new Enemy(675,600,'d');
	spider[33]= new Enemy(775,600,'d');
	spider[34]= new Enemy(775,700,'d');
	break;
	
	case 3:
	sword= new Sword(50,550);
	spider = new Enemy[8];
	spider[0] = new Enemy(250,450,'u');
	spider[1] = new Enemy(650,300,'d');
	spider[2] = new Enemy(300,700,'r');
	spider[3] = new Enemy(1050,350,'u');
	spider[4] = new Enemy(700,400,'r');
	spider[5] = new Enemy(750,600,'r');
	spider[6] = new Enemy(100,600,'l');
	spider[7] = new Enemy(150,400,'l');
	break;
	
	case 4:
	spider = new Enemy[27];
	spider[0] = new Enemy(50,50,'r');
	spider[1] = new Enemy(1400,50,'l');
	spider[2] = new Enemy(200,200,'d');
	spider[3] = new Enemy(300,350,'u');
	spider[4] = new Enemy(400,200,'d');
	spider[5] = new Enemy(500,350,'u');
	spider[6] = new Enemy(600,200,'d');
	spider[7] = new Enemy(700,350,'u');
	spider[8] = new Enemy(800,200,'d');
	spider[9] = new Enemy(900,350,'u');
	spider[10] = new Enemy(1000,200,'d');
	spider[11] = new Enemy(1100,350,'u');
	spider[12] = new Enemy(1200,200,'d');
	spider[13] = new Enemy(1300,350,'u');
	spider[14] = new Enemy(50,450,'r');
	spider[15] = new Enemy(1400,450,'l');
	spider[16] = new Enemy(725,500,'r');
	spider[17] = new Enemy(725,500,'l');
	spider[18] = new Enemy(50,550,'r');
	spider[19] = new Enemy(1400,550,'l');
	spider[20] = new Enemy(725,600,'r');
	spider[21] = new Enemy(725,600,'l');
	spider[22] = new Enemy(400,450,'d');
	spider[23] = new Enemy(1100,450,'d');
	spider[24] = new Enemy(50,650,'r');
	spider[25] = new Enemy(1400,650,'l');
	spider[26] = new Enemy(725,650,'u');

	break;
	//1500, 1070. Did you know that Trundle always goes bot?
	default: spider = new Enemy[1];
	spider[0]=new Enemy(700,100);
	}
}

boolean bounding_box_collision(int b1_x, int b1_y, int b1_w, int b1_h, int b2_x, int b2_y, int b2_w, int b2_h)
{
    if ((b1_x > b2_x + b2_w - 1) ||
        (b1_y > b2_y + b2_h - 1) ||
        (b2_x > b1_x + b1_w - 1) ||
        (b2_y > b1_y + b1_h - 1))   	    {

        return false;
    }


    return true;
}


boolean level_collision(int b1_x,int b1_y,int b1_w,int b1_h){
	int x=0,y=0;
	int holder[][] = map;
   switch (level) {
       case 1: holder = map;
       break;
   		case 2:holder = map2;
		break;
		case 3:holder = map3;
		break;
 		case 4:holder = map4;
		break; 
	    case 5:holder = map5;
		break;
	    case 6:holder = map6;
		break;
	    case 7:holder = map7;
		break;
	}

	 for(int i=0;i<21;i++){
	   x=0;
	   for(int j=0;j<30;j++){
		   if(holder[i][j]==32||holder[i][j]==31||holder[i][j]==30||holder[i][j]==29||holder[i][j]==28||holder[i][j]==27||
		   holder[i][j]==26||holder[i][j]==24||holder[i][j]==23||holder[i][j]==22||holder[i][j]==21||holder[i][j]==19||
		   holder[i][j]==18||holder[i][j]==17||holder[i][j]==16||holder[i][j]==15||holder[i][j]==14||holder[i][j]==13||
		   holder[i][j]==12||holder[i][j]==11||holder[i][j]==10||holder[i][j]==9||holder[i][j]==7||holder[i][j]==6||
		   holder[i][j]==5||holder[i][j]==4||holder[i][j]==3||holder[i][j]==2){
			  if(bounding_box_collision(b1_x,b1_y,b1_w,b1_h,x,y,img[map[i][j]].getWidth(),img[map[i][j]].getHeight())){return true;}	  
		   	}
	      x=x+SPRITE_WIDTH;
	      }
	    y=y+SPRITE_HEIGHT;
	 	}
	    return false;

	 }

public int checkEnemy(int p1x,int p1y, int p1w, int p1h,int attackDamage){
	   for(int i=0;i<spider.length;i++){
		   if(spider[i].getHp()>0)
		   	if(bounding_box_collision(p1x, p1y,p1w,p1h,spider[i].getX(),spider[i].getY(),spider[i].getWidth(),spider[i].getHeight())){
		   	  		 if(attackDamage>0)spider[i].takeDamage(attackDamage);
		   	  		 return spider[i].getDamage();
		   	}
	} return 0;
}

public int checkCoins(int lx,int ly, int lw, int lh){
		  for(int i=0;i<coins.length;i++){
		   	if(bounding_box_collision(lx, ly, lw, lh,coins[i].getX(),coins[i].getY(),coins[i].getWidth(),coins[i].getHeight())){
		   	  		 
		   	  		 return coins[i].getCash();
		   	}
	  	 }
   return 0;
}

public int checkHearts(int lx,int ly, int lw, int lh){
	/*int full=hp;
	for(int b=0;b<full;b++){
		return hearts[b].getHealth();
	}
	
	return full;*/
	for(int i=0;i<hearts.length;i++){
		if(bounding_box_collision(lx, ly, lw, lh,hearts[i].getX(),hearts[i].getY(),hearts[i].getWidth(),hearts[i].getHeight())){
		   	  		 return hearts[i].getHealth();
		}
	}
   return 0;
}

public boolean checkSword(int lx,int ly, int lw, int lh) {
	   	if(bounding_box_collision(lx, ly, lw, lh,sword.getX(),sword.getY(),sword.getWidth(),sword.getHeight())){
   	  		 sword.pickUp();
   	  		 return true;
		   	}
	return false;
}

public void draw(Graphics g){
int x=0,y=0;
 for(int i=0;i<21;i++){
   x=0;
   for(int j=0;j<30;j++){
   switch (level) {
       case 1: g.drawImage(img[map[i][j]],x,y,null);
       	break;
   		case 2:g.drawImage(img[map2[i][j]],x,y,null);
		break;
		case 3:g.drawImage(img[map3[i][j]],x,y,null);
		break;
 		case 4:g.drawImage(img[map4[i][j]],x,y,null);
		break;
	    case 5:g.drawImage(img[map5[i][j]],x,y,null);
		break;
	}
      x=x+SPRITE_WIDTH;
    }
    y=y+SPRITE_HEIGHT;
 }

 for(int i=0;i<spider.length;i++){
		if(spider[i].getHp()>0)
		spider[i].draw(g);
 }

if(level==1){
 		for(int b=0;b<coins.length; b++){
 			coins[b].draw(g);
 		}
}
 //if(level==2){
 	//for(int e=0;e<hearts.length;e++){
 	//		hearts[e].draw(g);
 	//	}
	//}
	try {
	if ( level ==3 ) {
		if ( ! sword.isPickedUp() ) {sword.draw(g); }
	}
	}catch(Exception e) {System.out.println(e); }

}

public boolean moveAI(Enemy m){
	char e_dir=m.getDirection();
	int fx=m.getX(),fy=m.getY();
	if(e_dir=='u')fy-=m.getSpeed();
	else if(e_dir=='d')fy+=m.getSpeed();
	else if(e_dir=='l')fx-=m.getSpeed();
	else if(e_dir=='r')fx+=m.getSpeed();

	if(level_collision(fx,fy,m.getWidth(), m.getHeight())){
		m.collide();
		/*
		int random=1-4
		m.setDirection(randomNumber);
		*/
		return false;
	}

	m.setMove(true);
	return true;


}


public void update(){
	for(int i=0;i<spider.length;i++){
	spider[i].update();
		if(spider[i].getHp()>0){
			if(moveAI(spider[i]));
			else{
			}
		}
	}
	for(int b=0; b<coins.length; b++){
			coins[b].update();
	}
 	for(int e=0;e<hearts.length;e++){
 			hearts[e].update();
 	}
}


}