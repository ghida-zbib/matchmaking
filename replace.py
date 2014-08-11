import re

def replace(n, t):
	f = open('project/algorithm/GaleShapley.java', 'r')
	contents = f.read()
	f.close()

	contents = re.sub(r"matchTests\[\d+x\d+With\d+Tests.txt", "matchTests[%dx%dWith%dTests.txt" % (n, n, t), contents)

	f = open('project/algorithm/GaleShapley.java', 'w')
	f.write(contents)
	f.close()

replace(100, 10)