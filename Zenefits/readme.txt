Problem:

Our app is about showing interesting people around a location. Interesting people are those who share a lot of friends and interests with you.

Input:
N -- number of commands. Followed by N lines, each of the format:
Op args 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 

Op can either be ‘Q’ or ‘W’.
Q is a query operation which takes two args: 
user_id miles
. Waral 鍗氬鏈夋洿澶氭枃绔�,
miles is always one of the 3 values: 1, 5 or 30.

W is the insertion operation, which takes args of the form: 
user_id lat lng interest_id1 weight1 interest_id2 weight2 .... 1point3acres.com/bbs

interest_ids are the set of all interests that user cares about. This could be his facebook friends or interests, each of them having a specific weight.

Output:

For each query operation, output a single line containing the top 10 (or less) user_id’s who are within the ‘miles’ radius of the user and have the highest scalar product of common interest weights. These must be sorted in the order of the weights highest to lowest, tie broken by user_id lowest to highest.

Constraints:. 1point3acres.com/bbs

This is more of a real-life problem, than a programming contest puzzle. So the test-case will reflect practically what happens in our software, and  not hand-generated corner cases.

Test case will have one densely populated university (Stanford) - 500 people, one city (Bay Area) - 50K people, and one sparsely populated country (US) - 500K people.

Each person has on average 5K interest_ids, which is a random number between 1 and 10K (interest_ids are not necessarily numbered 1 to 10K). Number of people who have a specific interest_id tends to follow power law distribution, with 20% of interests having 80% of user_ids, recursively..1point3acres缃�


Scoring: It’s a function of:
- Time taken for the program to run.
- Number of words of code. Therefore obfuscation doesn’t help much, you can gladly give large variable names. The idea is to keep the logic extremely simple.



Solution:


This is a very hard problem. 
I can think of four solutions. 
1) Given person p, find his top k friend within d miles, who has most common interests with him. Loop though all persons, find the top k friends. This takes O(nmlog(k)), where n is the number of persons, m is the average length of interests. This will fail for large ns. for example, millions of persons. 

2) Divide the total map into r*r grids. Use List<List<Grid>>, each grid store a list of persons. Given person p, you can find where he lived. Then explore his neighbor grids to find top k friends. This will fail for large maps. Since US has ~1000 miles, the query asks for 1mile grid. This will divide map into 1million grids, which is not doable. 

3) Use Geo Hash, interchangably concat lat and lng, then hash them. So that closer points will have closer hashcode. You can either store these persons into hash table's buckets, or store them on the file, which is more scable. But the geo hash function is not easy to implement. Since you cannot refer any resource, you may not be able to implement this. 

4) Use a QuadTree
See Wiki: http://en.wikipedia.org/wiki/Quadtree
A quad tree is a tree, each node can have zero or four child nodes. Each node covers a square on the map, [minLat, maxLat] * [minLng, maxLng]. So the root of the world has [-90,90]*[-180,180]. 

We only store persons on the leaf node. Each node has a size, indicating the number of persons under this node.
We can limit the size of leaf node, if it is more than 10. We can "divide" it into four child nodes, and move the existing persons in root node into its child nodes. In this way, we can gurantee, there aren't may persons in each node. 

When add a person into the quadtree. If current node is not leaf, go to one of the four child nodes. Until reach the leaf node, add this person into this node. If node size exceed limit, divide it. 

Given a person p, we want to collect those possible persons live within d miles away. i
Start from root, 
If current node is a leaf node, collect its persons. 
Else, check if the circle centered at p, with radius d intersects with any child nodes, we need to collect the persons in that node. 
_______________________
         |
   n1    |           p
         |      n2
         |
______________________         
         | 
  n3     |     n4
         |
_______________________      

After collecting those possible persons that within d miles with person p. We need to find the top k persons. We can use a priority queue to do this. I didn't implement this method. But it is simple. 


